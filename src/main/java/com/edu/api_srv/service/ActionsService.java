package com.edu.api_srv.service;


import com.edu.api_srv.dto.ActiveData;
import com.edu.api_srv.dto.RequestActiveDto;
import com.edu.api_srv.dto.cbr.RequestCurrencyDto;
import com.edu.api_srv.dto.yandex.DataRoutesDto;
import com.edu.api_srv.entity.yandex.DataRoute;
import com.edu.api_srv.entity.yandex.ResponseYandexApi;
import com.edu.api_srv.exception.exception.CurrencyNotFoundException;
import com.edu.api_srv.exception.exception.DownloadDataException;
import com.edu.api_srv.exception.exception.RouteNotFoundException;
import com.edu.api_srv.util.xml.CurrencyXmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;


@RequiredArgsConstructor
@Service
public class ActionsService {

    private final RestTemplate restTemplate;
    @Value("${app.yandex.key}")
    private String yandexApiKey;

    @Value("${app.cmc.key}")
    private String CMCApiKey;

    private final CurrencyXmlParser currencyXmlParser;

    private final String requiredCurrency = "USD";

    private String urlCbr = "https://cbr.ru/scripts/XML_daily.asp?date_req=";

    private String urlCMC = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=";

    private String apiYandexUrl = "https://api.routing.yandex.net/v2/distancematrix?origins=";

    private String urlYdx = "https://api.routing.yandex.net/v2/distancematrix?origins=";


    public DataRoute getResultByYandexApi(DataRoutesDto dataRoutesDto){

        String reqYnd = urlYdx + "25.249269,55.350952|25.248066,55.351206&destinations=25.225335,55.254270|25.230278,55.261586&apikey=";
        ResponseYandexApi respYdxApi = restTemplate.getForObject(reqYnd + yandexApiKey, ResponseYandexApi.class);

        if(respYdxApi.getRows().isEmpty()){
            throw new DownloadDataException("api.routing.yandex.net");
        }

        DataRoute routeWithShortestTime = respYdxApi.getRows().stream()
                .flatMap(row -> row.getListDataRoutes().stream())
                .min(Comparator.comparing(DataRoute::getDuration)).orElseThrow(RouteNotFoundException::new);

        return routeWithShortestTime;
    }
    public BigDecimal getResultRate(String symbolCrypto, BigDecimal amountPurchaseCrypto) {

        LocalDate currentDate = LocalDate.now();
        String strDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        RequestCurrencyDto requestResult = currencyXmlParser.toObject(restTemplate.getForObject(urlCbr + strDate, String.class));

        if (requestResult == null){
            throw new DownloadDataException("cbr.ru");
        }

        BigDecimal usdCurrencyRate = requestResult.getCurrencyList()
                .stream().filter(currency -> currency.getCharCode().equals(requiredCurrency))
                .findFirst().orElseThrow(()-> new CurrencyNotFoundException(requiredCurrency)).getValue();

        RequestActiveDto activeDataResult = restTemplate.getForObject(urlCMC + CMCApiKey, RequestActiveDto.class);

        if (activeDataResult == null){
            throw new DownloadDataException("coinmarketcap.com");
        }

        ActiveData crypto = activeDataResult.getData().stream()
                .filter(cur-> cur.getSymbol().equals(symbolCrypto)).findFirst()
                .orElseThrow(()-> new CurrencyNotFoundException(symbolCrypto));

        BigDecimal resultAmount = amountPurchaseCrypto.divide(usdCurrencyRate, 10, RoundingMode.HALF_UP)
                .divide(crypto.getQuote().getRateDataCrypto().getPrice(), 10, RoundingMode.HALF_UP);

        return resultAmount;

    }


}

