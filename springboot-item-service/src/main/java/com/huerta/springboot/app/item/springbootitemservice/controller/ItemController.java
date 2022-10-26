package com.huerta.springboot.app.item.springbootitemservice.controller;

import com.huerta.springboot.app.item.springbootitemservice.models.Item;
import com.huerta.springboot.app.item.springbootitemservice.models.Product;
import com.huerta.springboot.app.item.springbootitemservice.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

  private final ItemService itemService;

  @GetMapping
  public ResponseEntity<List<Item>> getAll() {
    log.info("Inside getAll");
    List<Item> findAll = this.itemService.findAll();
    log.info("items: {}", findAll);
    return ResponseEntity.ok(findAll);
  }

  // @HystrixCommand(fallbackMethod = "alternativeMethod")
  @GetMapping("{id}/amount/{amount}")
  public ResponseEntity<Item> getByProductIdandItemAmount(
    @PathVariable final Long id,
    @PathVariable final Integer amount
  ) {
    return ResponseEntity.ok(this.itemService.findById(id, amount));
  }

  public ResponseEntity<Item> alternativeMethod(final Long id, final Integer amount) {
    final Product product = new Product();
    product.setId(id);
    product.setName("Camara Sony");
    product.setPrice(500.00);
    final Item item = new Item(product, amount);
    return ResponseEntity.ok(item);
  }
}
