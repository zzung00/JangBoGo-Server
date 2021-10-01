package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByMarketId(Integer marketId);
    List<Product> findByMarket(Market market);
}
