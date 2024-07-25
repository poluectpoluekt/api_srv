package com.edu.api_srv.controller;


import com.edu.api_srv.dto.cbr.CalculatingAmountExchangeDto;
import com.edu.api_srv.dto.yandex.DataRoutesDto;
import com.edu.api_srv.entity.yandex.DataRoute;
import com.edu.api_srv.service.ActionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RequestMapping("/api/actions")
@RestController
public class ActionController {

    private final ActionsService actionsService;

    @PostMapping("/cb")
    public BigDecimal getDataCB(@RequestBody CalculatingAmountExchangeDto calculatingAmountExchangeDto){
        return actionsService.getResultRate(calculatingAmountExchangeDto.getSymbol(), calculatingAmountExchangeDto.getAmount());
    }

    @PostMapping("/ynd")
    public DataRoute getDateYan(@RequestBody DataRoutesDto dataRoutesDto){
       return actionsService.getResultByYandexApi(dataRoutesDto);
    }
}
