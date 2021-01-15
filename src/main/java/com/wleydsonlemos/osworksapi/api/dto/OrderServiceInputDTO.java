package com.wleydsonlemos.osworksapi.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class OrderServiceInputDTO {

    @NotNull
    private String description;

    @NotNull
    private Long ClientId;

    @NotNull
    private BigDecimal value;
}
