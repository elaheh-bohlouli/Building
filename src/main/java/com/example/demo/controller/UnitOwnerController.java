package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.UnitOwner;
import com.example.demo.service.UnitOwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/UnitOwner")
@RequiredArgsConstructor
public class UnitOwnerController {

    private final UnitOwnerService unitOwnerService;
    @PostMapping
    public UnitOwner insert (@RequestBody UnitOwner unitOwner){
        unitOwnerService.save(unitOwner);
        return unitOwner;
    }

    @GetMapping(value = "getById")
    public UnitOwner getById (@RequestParam int id) throws ItemNotFound {
        return unitOwnerService.findById(id).orElseThrow(()-> new ItemNotFound("UnitOwner does not exist"));
    }

    @GetMapping(value = "getAll")
    public List<UnitOwner> getAll (){
        return unitOwnerService.findAll();
    }

    @PutMapping
    public UnitOwner update (@RequestBody UnitOwner unitOwner){
        unitOwnerService.save(unitOwner);
        return unitOwner;
    }

    @DeleteMapping
    public void delete (@RequestParam int id){ unitOwnerService.deleteById(id);
    }
}
