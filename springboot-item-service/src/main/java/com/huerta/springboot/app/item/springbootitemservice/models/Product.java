package com.huerta.springboot.app.item.springbootitemservice.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  private Long id;
  private String name;
  private Double precio;
  private Date createAt;
}
