package com.wleydsonlemos.osworksapi.api.exceptionhandle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldsError {

    private String name;
    private String message;

}
