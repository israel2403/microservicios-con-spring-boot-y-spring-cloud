package com.huerta.springboot.app.products.springbootserviceproducts.controller;

import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;
import com.huerta.springboot.app.products.springbootserviceproducts.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> list() {
    return ResponseEntity.ok(this.productService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Product> detail(@PathVariable final Long id) {
    return ResponseEntity.ok(this.productService.findById(id));
  }
}
