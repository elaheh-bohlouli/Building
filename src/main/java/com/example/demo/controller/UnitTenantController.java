package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.UnitTenant;
import com.example.demo.service.UnitTenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/UnitTenant")
@RequiredArgsConstructor
public class UnitTenantController {

    private final UnitTenantService unitTenantService;
    @PostMapping
    public UnitTenant insert (@RequestBody UnitTenant unitTenant){
        unitTenantService.save(unitTenant);
        return unitTenant;
    }

    @GetMapping(value = "getById")
    public UnitTenant getById (@RequestParam int id) throws ItemNotFound {
        return unitTenantService.findById(id).orElseThrow(()-> new ItemNotFound("UnitTenant does not exist"));
    }

    @GetMapping(value = "getAll")
    public List<UnitTenant> getAll (){
        return unitTenantService.findAll();
    }

    @PutMapping
    public UnitTenant update (@RequestBody UnitTenant unitTenant){
        unitTenantService.save(unitTenant);
        return unitTenant;
    }

    @DeleteMapping
    public void delete (@RequestParam int id){
        unitTenantService.deleteById(id);
    }
}
