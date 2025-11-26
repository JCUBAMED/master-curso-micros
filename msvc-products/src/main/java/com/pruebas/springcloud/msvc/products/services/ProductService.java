package com.pruebas.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import com.pruebas.springcloud.msvc.products.entities.Products;

public interface ProductService {

    List<Products> findAll();
    Optional<Products> findById(Long id);

}
