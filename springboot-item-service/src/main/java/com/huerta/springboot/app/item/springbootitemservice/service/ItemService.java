package com.huerta.springboot.app.item.springbootitemservice.service;

import com.huerta.springboot.app.item.springbootitemservice.clients.ProductClientRest;
import com.huerta.springboot.app.item.springbootitemservice.models.Item;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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
