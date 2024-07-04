package com.vvsk.ecommerce.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vvsk.ecommerce.ecommerceapi.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

    List<CategoryEntity> findByName(String name);

}
