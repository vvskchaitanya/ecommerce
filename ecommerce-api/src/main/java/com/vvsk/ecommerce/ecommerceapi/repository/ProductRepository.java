package com.vvsk.ecommerce.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

    List<ProductEntity> findByName(String name);

    @Query(nativeQuery = true,value="select * from products where name like %:name%")
    List<ProductEntity> searchByName(@Param("name") String name);

}
