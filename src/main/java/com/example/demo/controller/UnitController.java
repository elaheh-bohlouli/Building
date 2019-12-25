package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.Unit;
import com.example.demo.service.UnitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/Unit")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;
    @PostMapping
    public Unit insert (@RequestBody Unit unit){
        unitService.save(unit);
        return unit;
    }

    @GetMapping(value = "getById")
    public Unit getById (@RequestParam int id) throws ItemNotFound {
        return unitService.findById(id).orElseThrow(()-> new ItemNotFound("Unit does not exist"));
    }

    @GetMapping(value = "getAll")
    public List<Unit> getAll (){
        return unitService.findAll();
    }

    @PutMapping
    public Unit update (@RequestBody Unit unit){
        unitService.save(unit);
        return unit;
    }

    @DeleteMapping
    public void delete (@RequestParam int id){ unitService.deleteById(id);
    }
}
