package com.example.demo.service;

import com.example.demo.model.UnitAddress;
import com.example.demo.repository.UnitAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnitAddressService {
        private final UnitAddressRepository unitAddressRepository;

//services:
        public List<UnitAddress> findAll() {
            return unitAddressRepository.findAll();
        }

        public Optional<UnitAddress> findById(Integer id) {
            return unitAddressRepository.findById(id);
        }

        public UnitAddress save(UnitAddress unitAddress) { return unitAddressRepository.save(unitAddress); }

        public void deleteById(Integer id) {
            unitAddressRepository.deleteById(id);
        }
}
