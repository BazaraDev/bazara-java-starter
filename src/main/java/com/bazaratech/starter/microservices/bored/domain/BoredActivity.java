package com.bazaratech.starter.microservices.bored.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoredActivity {
 
    private String activity;

    private String type;

    private int participant;

    private BigDecimal price;

    private String link;

    private String key;

    private int accessibility;
}
