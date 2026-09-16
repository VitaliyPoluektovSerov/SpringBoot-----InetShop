package org.skypro.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String name;
    private final UUID id;

    public Product(String name, UUID id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Наименование товара пустое!");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public UUID getId() {
        return id;
    }

    @Override
    @JsonIgnore
    public String searchTerm() {
        return name;
    }

    @Override
    @JsonIgnore
    public String searchType() {
        return "PRODUCT";
    }
}
