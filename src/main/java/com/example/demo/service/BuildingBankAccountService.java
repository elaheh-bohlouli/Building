package com.example.demo.service;

import com.example.demo.model.BuildingBankAccount;
import com.example.demo.repository.BuildingBankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BuildingBankAccountService {

        private final BuildingBankAccountRepository buildingBankAccountRepository;

//services:
        public List<BuildingBankAccount> findAll() {
            return buildingBankAccountRepository.findAll();
        }

        public Optional<BuildingBankAccount> findById(Integer id) {
            return buildingBankAccountRepository.findById(id);
        }

        public BuildingBankAccount save(BuildingBankAccount buildingBankAccount) {
            return buildingBankAccountRepository.save(buildingBankAccount);}

        public void deleteById(Integer id) {
            buildingBankAccountRepository.deleteById(id);
        }
}
