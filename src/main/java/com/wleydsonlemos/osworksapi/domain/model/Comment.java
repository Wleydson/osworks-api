package com.wleydsonlemos.osworksapi.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderService orderService;
    private String Title;
    private String description;
    private OffsetDateTime date;
}
