package com.pruebas.springcloud.msvc.items.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductuDTO {

    private Long id;
    private String name;
    private Double price;
    private LocalDate createAt;
    private int port;
}
