package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.Building;
import com.example.demo.model.Unit;
import com.example.demo.service.BuildingService;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BuildingController.class)
class BuildingControllerTest {
    @Mock
    BuildingService buildingService;

    @Rule
    ExpectedException thrown = ExpectedException.none();

    @MockBean
    BuildingController buildingController;
    Building building;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(buildingService.save(any(Building.class))).thenReturn(building);
        Building building = new Building(1 , "sakhtemane1" , "valieasr ST",
                "Mr. Mohamadi", 10, "0938096565656", new HashSet<Unit>());
        assert (building.getBuildingName()).equals("sakhtemane1");
    }

    @Test
    void update() {
        Building building= new Building();
        building.setId(1);
        building.setBuildingName("sakhtemane3");
        building.setUnitHashSets(new HashSet<>());
        building.setPhone("3156587087");
        building.setNumberOfUnits(30);
        building.setManager("Mr habibi");
        when(buildingService.save(building)).thenReturn(building);
    }

    @Test
    void delete() throws ItemNotFound {
        doNothing().when(buildingService).deleteById(1);
        buildingController.delete(1);
    }

    @Test
    void getById() {
        Building building= new Building();
        building.setId(1);
        building.setBuildingName("sakhtemaneh1");
        building.setBuildingAddress("valieasr street");
        building.setManager("Mr Amani");
        building.setNumberOfUnits(20);
        building.setPhone("093809609609");
        building.setUnitHashSets(new HashSet<>());
        when(buildingService.findById(1)).thenReturn(java.util.Optional.of(building));
    }

    @Test
    void getAll() {
        Building building1 = new Building(1 , "sakhtemane1" , "valieasr ST",
                "Mr. Mohamadi", 10, "0938096565656", new HashSet<Unit>());
        Building building2 = new Building(1 , "sakhtemane2" , "hemmat ST",
                "Mr. salehii", 30, "0938096565656", new HashSet<Unit>());
        List<Building> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        when(buildingService.findAll()).thenReturn(buildings);
        ArrayList<Building> result = (ArrayList<Building>) buildingService.findAll();
        assert (buildings.get(0).getBuildingName()).equals("sakhtemane1");
        assert (buildings.stream().count()==2);
    }

    @Test
    void getBuildingAccountBalance() throws ItemNotFound {
        when(buildingService.findById(anyInt())).thenReturn(Optional.of(new Building()));
        buildingController.getBuildingAccountBalance(1);

    }
}