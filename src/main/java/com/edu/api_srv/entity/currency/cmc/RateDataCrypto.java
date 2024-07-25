package com.edu.api_srv.entity.currency.cmc;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RateDataCrypto {

    private BigDecimal price;
    //private double price;

    @JsonProperty("last_updated")
    private LocalDate lastUpdated;
}
