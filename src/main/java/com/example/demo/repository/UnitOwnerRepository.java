package com.example.demo.repository;

import com.example.demo.model.UnitOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOwnerRepository extends JpaRepository<UnitOwner, Integer> {
}
