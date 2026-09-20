package org.skypro.model.basket;

import org.skypro.model.product.Product;
import org.skypro.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket basket;
    private final StorageService storageService;

    public BasketService(ProductBasket basket, StorageService storageService) {
        this.basket = basket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            basket.addProduct(id);
        } else {
            throw new IllegalArgumentException("Продукт с id " + id + " не найден");
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = basket.getProducts().entrySet().stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int quantity = entry.getValue();
                    Product product = storageService.getProductById(productId)
                            .orElseThrow(() -> new IllegalArgumentException("Продукт не найден!"));
                    return new BasketItem(product, quantity);
                })
                .collect(Collectors.toList());
        return new UserBasket(items);
    }
}
