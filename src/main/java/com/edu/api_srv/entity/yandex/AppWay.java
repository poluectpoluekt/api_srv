package com.edu.api_srv.entity.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppWay {

    private String status;
    private Distance distance;
    private Duration duration;
}
