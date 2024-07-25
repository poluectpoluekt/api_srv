package com.edu.api_srv.dto.yandex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DataRoutesDto {

    private String source;
    private String target;
    private String timeTransportation;
    private String traffic;
}
