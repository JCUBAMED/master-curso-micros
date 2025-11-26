package com.pruebas.springcloud.msvc.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pruebas.springcloud.msvc.items.models.ProductuDTO;

/* Configuracion de forma directa prueba 1*/
//@FeignClient(url = "localhost:8001", name = "msvc-products", path = "/api/products")

/* Configuracion de forma directa prueba 2*/
@FeignClient(name = "msvc-products", path = "/api/products")
public interface ProductFeignClient {

    @GetMapping
    List<ProductuDTO> findAll();

    @GetMapping("/{id}")
    ProductuDTO details(@PathVariable Long id);
}
