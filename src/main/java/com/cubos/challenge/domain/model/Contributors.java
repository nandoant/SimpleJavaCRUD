package com.cubos.challenge.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Contributors.table_name)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contributors {

    public final static String table_name = "contributors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String first_name;

    @Column(nullable = false)
    @NotBlank
    private String last_name;

    @Column(nullable = false)
    @NotNull
    private Long participation;

}
