package com.wleydsonlemos.osworksapi.api.dto;

import com.wleydsonlemos.osworksapi.domain.model.enumeration.StatusOrdemService;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class OrderServiceDTO {

    private Long id;
    private ClientDTO client;
    private String description;
    private BigDecimal value;
    private StatusOrdemService status;
    private OffsetDateTime dateInitial;
    private OffsetDateTime dateEnd;
    private List<CommentDTO> comments;

}
