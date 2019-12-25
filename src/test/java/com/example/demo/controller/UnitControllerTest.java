package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.*;
import com.example.demo.service.UnitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UnitController.class)
class UnitControllerTest {    @Mock
UnitService unitService;

    @MockBean
    UnitController unitController;
    Unit unit;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        when(unitService.save(any(Unit.class))).thenReturn(unit);
        Unit unit = new Unit(1, 54L, 87L, 21L, new UnitTenant(), new UnitAddress(),
                new UnitOwner(), new Building());
        assert (unit.getArea())==54L;
    }
    @Test
    void update() {
        Unit unit= new Unit();
        unit.setId(1);
        unit.setArea(87l);
        unit.setChargeAmount(55l);
        unit.setUnitNumber(50l);
        when(unitService.save(unit)).thenReturn(unit);
    }

    @Test
    void delete() throws ItemNotFound {
        doNothing().when(unitService).deleteById(1);
        unitController.delete(1);
    }

    @Test
    void getById() {
        Unit unit= new Unit();
        unit.setId(1);
        unit.setArea(87l);
        unit.setChargeAmount(55l);
        unit.setUnitNumber(50l);
        when(unitService.findById(1)).thenReturn(java.util.Optional.of(unit));
    }

    @Test
    void getAll() {
        Unit unit1 = new Unit(1, 54L, 87L, 21L, new UnitTenant(), new UnitAddress(),
                new UnitOwner(), new Building());
        Unit unit2 = new Unit(2, 100L, 800L, 9L, new UnitTenant(), new UnitAddress(),
                new UnitOwner(), new Building());
        List<Unit> units = new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        when(unitService.findAll()).thenReturn(units);
        ArrayList<Unit> result = (ArrayList<Unit>) unitService.findAll();
        assert (units.get(0).getUnitNumber())==21l;
    }
}