package com.huerta.springboot.app.products.springbootserviceproducts.service;

import com.huerta.springboot.app.products.springbootserviceproducts.dao.ProductDAO;
import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductDAO productDAO;

  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) productDAO.findAll();
  }

  @Transactional(readOnly = true)
  public Product findById(final Long id) {
    return this.productDAO.findById(id).orElse(null);
  }
}
