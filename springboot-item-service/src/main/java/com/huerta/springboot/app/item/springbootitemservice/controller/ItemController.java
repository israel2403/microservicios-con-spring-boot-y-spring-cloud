package com.huerta.springboot.app.item.springbootitemservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.springboot.app.item.springbootitemservice.models.Item;
import com.huerta.springboot.app.item.springbootitemservice.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {
  private final  ItemService itemService;

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
