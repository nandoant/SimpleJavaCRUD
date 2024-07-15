package com.cubos.challenge.contributors.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class PercentageDTO {

    private Long id;
    private BigDecimal percentage;

    //id | perct
    //1 50
    //2 25
    //3 25
}
