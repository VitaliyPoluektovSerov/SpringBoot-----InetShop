package org.skypro.service.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.service.StorageService;
import org.skypro.service.SearchService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skypro.model.product.DiscountedProduct;
import org.skypro.model.product.Product;
import org.skypro.model.product.SimpleProduct;
import org.skypro.model.search.SearchResult;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class StorageServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.searchService = new SearchService(storageService);
    }

    @Mock
    private StorageService storageService;

    private SearchService searchService;

    Product product1 = new DiscountedProduct("Киви", 55, 10, UUID.randomUUID());
    Product product2 = new SimpleProduct("Арбуз", 120, UUID.randomUUID());


    @Test
    void testSearchWhenStorageIsEmpty() {
        Mockito.when(storageService.getAllSearchables()).thenReturn(List.of());
        Collection<SearchResult> search = searchService.search("Something");
        Assertions.assertTrue(search.isEmpty());
    }

    @Test
    void testSearchNoSuitableObject() {
        Mockito.when(storageService.getAllSearchables()).thenReturn(List.of(product1, product2));
        Collection<SearchResult> search = searchService.search("Апельсин");
        Assertions.assertTrue(search.isEmpty(), "Нет подходящего объекта");
    }

    @Test
    void testSearchHasSuitableObject() {
        Mockito.when(storageService.getAllSearchables()).thenReturn(List.of(product1, product2));
        Collection<SearchResult> search = searchService.search("Арбуз");
        Assertions.assertEquals(1, search.size());
    }
}