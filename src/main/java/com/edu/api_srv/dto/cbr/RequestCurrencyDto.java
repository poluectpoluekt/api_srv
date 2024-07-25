package com.edu.api_srv.dto.cbr;


import com.edu.api_srv.entity.currency.Currency;
import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@XmlRootElement(name = "ValCurs")
public class RequestCurrencyDto {

    private String name;

    private String date;

    private List<Currency> currencyList;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    @XmlElement(name = "Valute")
    public List<Currency> getCurrencyList() {
        return currencyList;
    }
}
