package com.sevenine.conecta.http_.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@AllArgsConstructor
public class HyperMediaResponse extends RepresentationModel<HyperMediaResponse> {
    private final boolean success;
    private final Integer status;
    private final Object data;
}
