package com.edu.api_srv.dto;


import com.edu.api_srv.entity.currency.cmc.Quote;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActiveData {

    private String name;
    private String symbol;

    @JsonProperty("last_updated")
    private LocalDate lastUpdated;
    private Quote quote;

}
