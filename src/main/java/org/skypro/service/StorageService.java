package org.skypro.service;

import org.skypro.model.article.Article;
import org.skypro.model.product.DiscountedProduct;
import org.skypro.model.product.FixPriceProduct;
import org.skypro.model.product.Product;
import org.skypro.model.product.SimpleProduct;

import java.util.*;

import org.skypro.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    private final Map<UUID, Product> listProduct = new HashMap<>();
    private final Map<UUID, Article> listArticle = new HashMap<>();

    public StorageService() {
        this.addProducts();
        this.addArticles();
    }

    private void addProducts() {
        UUID id = UUID.randomUUID();
        SimpleProduct prod1 = new SimpleProduct("Апельсин", 174, id);
        id = UUID.randomUUID();
        SimpleProduct prod2 = new SimpleProduct("Колбаса", 274, id);
        id = UUID.randomUUID();
        SimpleProduct prod3 = new SimpleProduct("Банан", 49, id);
        id = UUID.randomUUID();
        DiscountedProduct prod4 = new DiscountedProduct("Икра", 200, 20, id);
        id = UUID.randomUUID();
        SimpleProduct prod5 = new SimpleProduct("Вино", 58, id);
        id = UUID.randomUUID();
        SimpleProduct prod6 = new SimpleProduct("Яблоко", 24, id);
        id = UUID.randomUUID();
        SimpleProduct prod7 = new SimpleProduct("Виноград", 145, id);
        id = UUID.randomUUID();
        FixPriceProduct prod8 = new FixPriceProduct("Лапша", id);
        id = UUID.randomUUID();
        SimpleProduct prod9 = new SimpleProduct("Арбуз", 56, id);
        id = UUID.randomUUID();
        SimpleProduct prod10 = new SimpleProduct("Макароны", 44, id);
        listProduct.put(prod1.getId(), prod1);
        listProduct.put(prod2.getId(), prod2);
        listProduct.put(prod3.getId(), prod3);
        listProduct.put(prod4.getId(), prod4);
        listProduct.put(prod5.getId(), prod5);
        listProduct.put(prod6.getId(), prod6);
        listProduct.put(prod7.getId(), prod7);
        listProduct.put(prod8.getId(), prod8);
        listProduct.put(prod9.getId(), prod9);
        listProduct.put(prod10.getId(), prod10);
    }

    private void addArticles() {
        UUID id = UUID.randomUUID();
        Article art1 = new Article("Шапка", "Черная, шерсть, с козырьком", id);
        id = UUID.randomUUID();
        Article art2 = new Article("Футболка", "Красная, хлопок", id);
        id = UUID.randomUUID();
        Article art3 = new Article("Платье", "Розовой, шелковое, в пол", id);
        id = UUID.randomUUID();
        Article art4 = new Article("Майка", "Белая, хлопок", id);
        id = UUID.randomUUID();
        Article art5 = new Article("Пальто", "Черное, шерсть, по пояс", id);
        listArticle.put(art1.getId(), art1);
        listArticle.put(art2.getId(), art2);
        listArticle.put(art3.getId(), art3);
        listArticle.put(art4.getId(), art4);
        listArticle.put(art5.getId(), art5);
    }

    public Collection<Article> getAllArticles() {
        return listArticle.values();
    }

    public Collection<Product> getAllProducts() {
        return listProduct.values();
    }

    public List<Searchable> getAllSearchables(){
        List<Searchable> list = new ArrayList<>();
        list.addAll(listProduct.values());
        list.addAll(listArticle.values());
        return list;
    }
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(listProduct.get(id));
    }

}
