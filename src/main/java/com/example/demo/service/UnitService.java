package com.example.demo.service;

import com.example.demo.model.Unit;
import com.example.demo.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnitService {
        private final UnitRepository unitRepository;

//services:
        public List<Unit> findAll() {
            return unitRepository.findAll();
        }

        public Optional<Unit> findById(Integer id) {
            return unitRepository.findById(id);
        }

        public Unit save(Unit unit) { return unitRepository.save(unit); }

        public void deleteById(Integer id) {
            unitRepository.deleteById(id);
        }
}
