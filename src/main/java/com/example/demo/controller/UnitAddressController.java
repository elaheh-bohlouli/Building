package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.UnitAddress;
import com.example.demo.service.UnitAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/unitAddress")
@RequiredArgsConstructor
public class UnitAddressController {

    private final UnitAddressService unitAddressService;

    @PostMapping
    public UnitAddress insert (@RequestBody UnitAddress unitAddress){

        unitAddressService.save(unitAddress);
        return unitAddress;
    }

    @GetMapping(value = "getById")
    public UnitAddress getById (@RequestParam int id) throws ItemNotFound {
        return unitAddressService.findById(id).orElseThrow(()-> new ItemNotFound("UnitAddress does not exist"));
    }

    @GetMapping(value = "getAll")
    public List<UnitAddress> getAll (){
        return unitAddressService.findAll();
    }

    @PutMapping
    public UnitAddress update (@RequestBody UnitAddress unitAddress){

        unitAddressService.save(unitAddress);
        return unitAddress;
    }

    @DeleteMapping
    public void delete (@RequestParam int id){
        unitAddressService.deleteById(id);
    }


    @GetMapping (value = "getPostalAddress")
    public String getPostalAddress(int id) throws ItemNotFound {
        String postAddress = unitAddressService
                .findById(id).orElseThrow(() -> new ItemNotFound("UnitAddress does not exist")).getPostAddress();
        return postAddress;
    }
}
