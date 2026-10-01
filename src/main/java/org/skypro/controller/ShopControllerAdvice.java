
package org.skypro.controller;

import org.skypro.errors.ShopError;
import org.skypro.service.exceptions.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        ShopError shopError = new ShopError("404", "Нет такого продукта");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(shopError);
    }


}
