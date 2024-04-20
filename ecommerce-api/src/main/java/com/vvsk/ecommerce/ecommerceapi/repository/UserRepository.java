package com.vvsk.ecommerce.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    List<UserEntity> findByUsername(String username);

}
