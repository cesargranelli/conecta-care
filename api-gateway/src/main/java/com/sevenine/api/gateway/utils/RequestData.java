package com.sevenine.api.gateway.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestData {

    private String path;
    private String bearer;
    private HttpHeaders headers;
    private String body;

}
