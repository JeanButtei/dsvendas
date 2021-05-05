package com.jeanbuttei.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanbuttei.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}