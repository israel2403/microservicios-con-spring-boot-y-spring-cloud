package com.huerta.springboot.app.item.springbootitemservice.service;

import com.huerta.springboot.app.item.springbootitemservice.models.Item;
import com.huerta.springboot.app.item.springbootitemservice.models.Product;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

  private final RestTemplate restClient;

  public List<Item> findAll() {
    List<Product> products = Arrays.asList(
      restClient.getForObject(
        "http://products-service/products",
        Product[].class
      )
    );
    return products
      .stream()
      .map(product -> new Item(product, 1))
      .collect(Collectors.toList());
  }

  public Item findById(final Long id, final Integer amount) {
    final Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", id.toString());
    Product product = restClient.getForObject(
      "http://products-service/products/{id}",
      Product.class,
      pathVariables
    );
    return new Item(product, amount);
  }
}
