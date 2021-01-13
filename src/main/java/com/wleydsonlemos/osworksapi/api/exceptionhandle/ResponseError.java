package com.wleydsonlemos.osworksapi.api.exceptionhandle;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ResponseError  {

    private Integer status;
    private LocalDateTime dateTime;
    private String error;
    private List<FieldsError> fieldsError;
}
