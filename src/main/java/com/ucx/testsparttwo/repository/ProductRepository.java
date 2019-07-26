package com.ucx.testsparttwo.repository;

import com.ucx.testsparttwo.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

}
