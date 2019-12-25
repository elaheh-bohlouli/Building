package com.example.demo.service;

import com.example.demo.model.UnitTenant;
import com.example.demo.repository.UnitTenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnitTenantService {
        private final UnitTenantRepository unitTenantRepository;

//services:
        public List<UnitTenant> findAll() {
            return unitTenantRepository.findAll();
        }

        public Optional<UnitTenant> findById(Integer id) {
            return unitTenantRepository.findById(id);
        }

        public UnitTenant save(UnitTenant unitTenant) { return unitTenantRepository.save(unitTenant); }

        public void deleteById(Integer id) {
            unitTenantRepository.deleteById(id);
        }
}
