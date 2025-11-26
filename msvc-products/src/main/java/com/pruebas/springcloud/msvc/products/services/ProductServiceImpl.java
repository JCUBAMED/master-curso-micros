package com.pruebas.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.springcloud.msvc.products.entities.Products;
import com.pruebas.springcloud.msvc.products.repositories.ProductRepository;

@Service
/** 
 * Anotacion de solo lectura
 * 
 *  @Transactional = (readOnly = true)
 * 
 * */
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final Environment environment;

    public ProductServiceImpl(ProductRepository repository, Environment environment) {
        this.environment = environment;
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Products> findAll() {
        return ((List<Products>) repository.findAll()).stream().map(product -> {
            // Obtener el puerto del entorno
            String port = environment.getProperty("local.server.port");
            product.setPort(Integer.parseInt(port));
            return product;
        }).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Products> findById(Long id) {
        return repository.findById(id).map(product -> {
            // Obtener el puerto del entorno
            String port = environment.getProperty("local.server.port");
            product.setPort(Integer.parseInt(port));
            return product;
        });
    }

}
