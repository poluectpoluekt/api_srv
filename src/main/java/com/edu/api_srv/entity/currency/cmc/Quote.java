package com.edu.api_srv.entity.currency.cmc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Quote {

    @JsonProperty("USD")
    private RateDataCrypto rateDataCrypto;
}
