package com.huerta.springboot.app.item.springbootitemservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.huerta.springboot.app.item.springbootitemservice.clients.ProductClientRest;
import com.huerta.springboot.app.item.springbootitemservice.models.Item;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ProductClientRest productClientRest;

  public List<Item> findAll() {
    return this.productClientRest.list()
      .stream()
      .map(product -> new Item(product, 1))
      .collect(Collectors.toList());
  }

  public Item findById(final Long id, final Integer amount) {
    return new Item(this.productClientRest.detail(id), amount);
  }
}
