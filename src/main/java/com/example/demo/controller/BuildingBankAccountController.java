package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.BuildingBankAccount;
import com.example.demo.service.BuildingBankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/BuildingBankAccount")
@RequiredArgsConstructor
public class BuildingBankAccountController {
    private final BuildingBankAccountService buildingBankAccountService;

    @PostMapping
    public BuildingBankAccount insert (@RequestBody BuildingBankAccount buildingBankAccount){
        buildingBankAccountService.save(buildingBankAccount);
        return buildingBankAccount;
    }

    @GetMapping(value = "getById")
    public BuildingBankAccount getById (@RequestParam int id) throws ItemNotFound {
        return buildingBankAccountService.findById(id).orElseThrow(()-> new ItemNotFound("BuildingBankAccount does not exist"));
    }


    @GetMapping(value = "getAll")
    public List<BuildingBankAccount> getAll (){
        return  buildingBankAccountService.findAll();
    }

    @PutMapping
    public BuildingBankAccount update (@RequestParam int id) throws ItemNotFound {
        BuildingBankAccount buildingBankAccount = buildingBankAccountService.findById(id)
                .orElseThrow(() -> new ItemNotFound("BuildingBankAccount does not exist"));
        buildingBankAccountService.save(buildingBankAccount);
        return buildingBankAccount;
    }

    @DeleteMapping
    public void delete (@RequestParam int id) {
        buildingBankAccountService.deleteById(id);
    }

}
