package com.huerta.springboot.app.products.springbootserviceproducts.controller;

import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;
import com.huerta.springboot.app.products.springbootserviceproducts.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

  private final ServletWebServerApplicationContext webServerAppCtxt;

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> list() {
    return ResponseEntity.ok(
      this.productService.findAll()
        .stream()
        .map(
          product -> {
            product.setPort(webServerAppCtxt.getWebServer().getPort());
            return product;
          }
        )
        .collect(Collectors.toList())
    );
  }

  @GetMapping("{id}")
  public ResponseEntity<Product> detail(@PathVariable final Long id) {
    final Product product = this.productService.findById(id);
    product.setPort(webServerAppCtxt.getWebServer().getPort());
   /*  try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } */
    return ResponseEntity.ok(product);
  }
}
