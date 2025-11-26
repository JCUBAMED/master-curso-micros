package com.pruebas.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

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

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Products> findAll() {
        return (List<Products>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Products> findById(Long id) {
        return repository.findById(id);
    }

}
