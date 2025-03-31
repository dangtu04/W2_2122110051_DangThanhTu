package com.dangthanhtu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dangthanhtu.backend.entity.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
}