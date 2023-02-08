package com.huerta.springboot.app.item.springbootitemservice.clients;

import com.huerta.springboot.app.item.springbootitemservice.models.Product;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface ProductClientRest {
  @GetMapping("products")
  public List<Product> list();

  @GetMapping("products/{id}")
  public Product detail(@PathVariable(value = "id") final Long id);
}
