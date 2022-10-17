package com.huerta.springboot.app.item.springbootitemservice.controller;

import com.huerta.springboot.app.item.springbootitemservice.models.Item;
import com.huerta.springboot.app.item.springbootitemservice.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
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

  @GetMapping("{id}/amount/{amount}")
  public ResponseEntity<Item> getByProductIdandItemAmount(
    @PathVariable final Long id,
    @PathVariable final Integer amount
  ) {
    return ResponseEntity.ok(this.itemService.findById(id, amount));
  }
}
