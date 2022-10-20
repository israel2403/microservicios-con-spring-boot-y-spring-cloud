package com.huerta.springboot.app.products.springbootserviceproducts.controller;

import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;
import com.huerta.springboot.app.products.springbootserviceproducts.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

  // private final Environment environment;

  @Value("{server.port}")
  private Integer port;

  @GetMapping
  public ResponseEntity<List<Product>> list() {
    return ResponseEntity.ok(
      this.productService.findAll()
        .stream()
        .map(
          product -> {
            /* product.setPort(
              Integer.parseInt(environment.getProperty("local.server.port"))
            ); */
            product.setPort(this.port);
            return product;
          }
        )
        .collect(Collectors.toList())
    );
  }

  @GetMapping("{id}")
  public ResponseEntity<Product> detail(@PathVariable final Long id) {
    final Product product = this.productService.findById(id);
    /* product.setPort(
      Integer.parseInt(environment.getProperty("local.server.port"))
    ); */
    product.setPort(this.port);
    return ResponseEntity.ok(product);
  }
}
