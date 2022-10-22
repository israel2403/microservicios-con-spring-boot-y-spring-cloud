package com.huerta.springboot.app.item.springbootitemservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

  private Product product;
  private Integer amount;

  public Item() {}

  public Item(final Product product, Integer amount) {
    this.product = product;
    this.amount = amount;
  }

  public Double calculateTotal() {
    return product.getPrice() * amount.doubleValue();
  }
}
