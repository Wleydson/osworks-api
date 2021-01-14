package com.wleydsonlemos.osworksapi.domain.model;

import com.wleydsonlemos.osworksapi.domain.model.enumeration.StatusOrdemService;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private StatusOrdemService status;

    private LocalDateTime dateInitial;
    private LocalDateTime dateEnd;
}
