package com.wleydsonlemos.osworksapi.api.exceptionhandle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError  {

    private Integer status;
    private LocalDateTime dateTime;
    private String error;
    private List<FieldsError> fieldsError;
}
