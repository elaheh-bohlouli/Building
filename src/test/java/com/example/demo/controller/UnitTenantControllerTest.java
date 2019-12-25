package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.UnitTenant;
import com.example.demo.service.UnitTenantService;
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
@WebMvcTest(UnitTenantController.class)
class UnitTenantControllerTest {
    @Mock
    UnitTenantService unitTenantService;

    @MockBean
    UnitTenantController unitTenantController;
    UnitTenant unitTenant;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        when(unitTenantService.save(any(UnitTenant.class))).thenReturn(unitTenant);
        UnitTenant unitTenant = new UnitTenant(1, 5, "chali", "boy", "09380850000");
        assert (unitTenant.getName()).equals("chali");
    }
    @Test
    void update() {
        UnitTenant unitTenant= new UnitTenant();
        unitTenant.setId(1);
        unitTenant.setTenantNumber(1);
        unitTenant.setName("elaa");
        unitTenant.setLastName("nokhdi");
        unitTenant.setPhone("03980880888");
        when(unitTenantService.save(unitTenant)).thenReturn(unitTenant);
    }

    @Test
    void delete() throws ItemNotFound {
        doNothing().when(unitTenantService).deleteById(1);
        unitTenantController.delete(1);
    }

    @Test
    void getById() {
        UnitTenant unitTenant= new UnitTenant();
        unitTenant.setId(1);
        unitTenant.setTenantNumber(1);
        unitTenant.setName("elaa");
        unitTenant.setLastName("nokhdi");
        unitTenant.setPhone("03980880888");
        when(unitTenantService.findById(1)).thenReturn(java.util.Optional.of(unitTenant));
    }

    @Test
    void getAll() {
        UnitTenant unitTenant1 = new UnitTenant(1, 5, "chali", "boy", "09380850000");
        UnitTenant unitTenant2 = new UnitTenant(3, 3, "ela", "b", "09380000000");
        List<UnitTenant> unitTenants = new ArrayList<>();
        unitTenants.add(unitTenant1);
        unitTenants.add(unitTenant2);
        when(unitTenantService.findAll()).thenReturn(unitTenants);
        ArrayList<UnitTenant> result = (ArrayList<UnitTenant>) unitTenantService.findAll();
        assert (unitTenants.get(0).getName()).equals("chali");
    }
}