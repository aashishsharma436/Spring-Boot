package com.springbootTrendNext.Assessment1.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootTrendNext.Assessment1.entity.ProductDetailsEntity;
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetailsEntity, Integer>{
}
