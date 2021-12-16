package com.example.Product_Management.Repository;

import com.example.Product_Management.DTO.MasterProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterProductRepository extends JpaRepository<MasterProduct, Integer> {
}
