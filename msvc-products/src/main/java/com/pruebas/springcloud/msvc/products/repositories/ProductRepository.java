package com.pruebas.springcloud.msvc.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.springcloud.msvc.products.entities.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long>{

}
