package com.wleydsonlemos.osworksapi.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentInputDTO {

    @NotNull
    private String title;

    @NotNull
    private String description;
}
