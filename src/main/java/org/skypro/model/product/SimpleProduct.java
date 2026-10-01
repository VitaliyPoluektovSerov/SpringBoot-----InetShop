package org.skypro.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price, UUID id) {
        super(name, id);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена либо 0, либо отрицательная!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
