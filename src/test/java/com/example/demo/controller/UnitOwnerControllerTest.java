package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.UnitOwner;
import com.example.demo.service.UnitOwnerService;
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
@WebMvcTest(UnitOwnerController.class)
class UnitOwnerControllerTest {
    @Mock
    UnitOwnerService unitOwnerService;

    @MockBean
    UnitOwnerController unitOwnerController;
    UnitOwner unitOwner;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        when(unitOwnerService.save(any(UnitOwner.class))).thenReturn(unitOwner);
        UnitOwner unitOwner = new UnitOwner(1, "eala", "bh", "09389389385");
        assert (unitOwner.getName()).equals("eala");
    }
    @Test
    void update() {
        UnitOwner unitOwner= new UnitOwner();
        unitOwner.setId(1);
        unitOwner.setName("elaa");
        unitOwner.setLastName("nokhdi");
        unitOwner.setPhone("03980880888");
        when(unitOwnerService.save(unitOwner)).thenReturn(unitOwner);
    }

    @Test
    void delete() throws ItemNotFound {
        doNothing().when(unitOwnerService).deleteById(1);
        unitOwnerController.delete(1);
    }

    @Test
    void getById() {
        UnitOwner unitOwner= new UnitOwner();
        unitOwner.setId(1);
        unitOwner.setName("elaa");
        unitOwner.setLastName("nokhdi");
        unitOwner.setPhone("03980880888");
        when(unitOwnerService.findById(1)).thenReturn(java.util.Optional.of(unitOwner));
    }

    @Test
    void getAll() {
        UnitOwner unitOwner1 = new UnitOwner(1, "eala", "bh", "09389389385");
        UnitOwner unitOwner2 = new UnitOwner(2, "hana", "boh", "09389300085");
        List<UnitOwner> unitOwners = new ArrayList<>();
        unitOwners.add(unitOwner1);
        unitOwners.add(unitOwner2);
        when(unitOwnerService.findAll()).thenReturn(unitOwners);
        ArrayList<UnitOwner> result = (ArrayList<UnitOwner>) unitOwnerService.findAll();
        assert (unitOwners.get(0).getName()).equals("eala");
    }
}
