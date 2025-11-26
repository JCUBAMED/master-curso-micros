package com.pruebas.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.springcloud.msvc.items.client.ProductFeignClient;
import com.pruebas.springcloud.msvc.items.models.Item;
import com.pruebas.springcloud.msvc.items.models.ProductuDTO;

import feign.FeignException;

@Service
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductFeignClient client;


    @Override
    public List<Item> findAll() {
        return client.findAll()
              .stream()
              .map(product -> new Item(product, new Random().nextInt(10) + 1))
              .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        try {
            ProductuDTO product = client.details(id);
            return Optional.of(new Item(product, new Random().nextInt(10) + 1));
        } catch (FeignException e) {
            return Optional.empty();
        }
    }

}
