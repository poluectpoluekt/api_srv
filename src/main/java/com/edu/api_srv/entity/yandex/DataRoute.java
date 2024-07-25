package com.edu.api_srv.entity.yandex;


import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DataRoute {

    private String status;
    private Distance distance;
    private Duration duration;
}
