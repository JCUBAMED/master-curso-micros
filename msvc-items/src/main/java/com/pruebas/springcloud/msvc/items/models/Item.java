package com.pruebas.springcloud.msvc.items.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private ProductuDTO product;
    private int quantity;

    public Item() {
    }

    public Item(ProductuDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Double getTotal(){
        return product.getPrice() * quantity;
    }
}
