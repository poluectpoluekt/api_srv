package com.edu.api_srv.dto.cbr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatingAmountExchangeDto {

    private String symbol;
    private BigDecimal amount;
}
