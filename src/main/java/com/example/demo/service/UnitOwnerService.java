package com.example.demo.service;

import com.example.demo.model.UnitOwner;
import com.example.demo.repository.UnitOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnitOwnerService {
        private final UnitOwnerRepository unitOwnerRepository;

//services:
        public List<UnitOwner> findAll() {
            return unitOwnerRepository.findAll();
        }

        public Optional<UnitOwner> findById(Integer id) {
            return unitOwnerRepository.findById(id);
        }

        public UnitOwner save(UnitOwner unitOwner) { return unitOwnerRepository.save(unitOwner); }

        public void deleteById(Integer id) {
            unitOwnerRepository.deleteById(id);
        }
}
