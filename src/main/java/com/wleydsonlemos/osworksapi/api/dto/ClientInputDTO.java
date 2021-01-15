package com.wleydsonlemos.osworksapi.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClientInputDTO {

    @NotBlank
    @Size(max=60)
    private String name;

    @NotBlank
    @Email
    @Size(max=255)
    private String email;

    @NotBlank
    @Size(max=20)
    private String phone;
}
