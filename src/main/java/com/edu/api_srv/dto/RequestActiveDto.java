package com.edu.api_srv.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestActiveDto {

    private List<ActiveData> data;
}
