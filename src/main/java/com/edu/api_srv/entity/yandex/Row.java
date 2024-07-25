package com.edu.api_srv.entity.yandex;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Row {

    @JsonProperty("elements")
    private List<DataRoute> listDataRoutes;
}
