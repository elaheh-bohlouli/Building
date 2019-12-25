package com.example.demo.service;

import com.example.demo.model.Building;
import com.example.demo.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BuildingService {
        private final BuildingRepository buildingRepository;

//services:
        public List<Building> findAll() {return buildingRepository.findAll();
        }

        public Optional<Building> findById(Integer id) {
            return buildingRepository.findById(id);
        }

        public Building save(Building building) {
            return buildingRepository.save(building);
        }

        public void deleteById(Integer id) {
            buildingRepository.deleteById(id);
        }
}
