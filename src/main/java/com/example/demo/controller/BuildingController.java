package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.Building;
import com.example.demo.model.Unit;
import com.example.demo.service.BuildingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/Building")
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @PostMapping
    public Building insert (@RequestBody Building building){

        buildingService.save(building);
        return building;
    }

    @PutMapping
    public Building update (@RequestBody Building building){

        buildingService.save(building);
        return building;
    }

    @DeleteMapping
    public void delete (@RequestParam int id){
        buildingService.deleteById(id);
    }

    @GetMapping(value = "getById")
    public Building getById (@RequestParam int id) throws ItemNotFound {
        return buildingService.findById(id).orElseThrow(()-> new ItemNotFound("Building does not exist"));
    }

    @GetMapping(value = "getAll")
    public List<Building> getAll (){return buildingService.findAll();
    }

    @GetMapping(value = "buildingBankAccountBalance")
    public Long getBuildingAccountBalance(@RequestParam int id) throws ItemNotFound {
        Building buildingForAccount = buildingService.findById(id)
                .orElseThrow(() -> new ItemNotFound("Building does not exist"));
        Long buildingAccountBalance = null;
        for (Unit everyUnit : buildingForAccount.getUnitHashSets()) {
            long chargeAmount = everyUnit.getChargeAmount();
            buildingAccountBalance = chargeAmount + buildingAccountBalance;
        };
        return buildingAccountBalance;
    }
}
