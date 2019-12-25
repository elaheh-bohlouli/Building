package com.example.demo.controller;

import com.example.demo.model.UnitAddress;
import com.example.demo.service.UnitAddressService;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
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
@WebMvcTest(UnitAddressController.class)
class UnitAddressControllerTest {
    @Mock
    UnitAddressService unitAddressService;

    @Rule
    ExpectedException thrown = ExpectedException.none();

    @MockBean
    com.example.demo.controller.UnitAddressController UnitAddressController;
    UnitAddress unitAddress;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        when(unitAddressService.save(any(UnitAddress.class))).thenReturn(unitAddress);
        UnitAddress unitAddress = new UnitAddress(1 , "tehran", "tehran", "gharb", "toehid", "one", "15");
        assert (unitAddress.getPostCode()).equals("toehid");
    }

    @Test
    void getById() {
        UnitAddress unitAddress= new UnitAddress();
        unitAddress.setId(1);
        unitAddress.setCity("urmia");
        unitAddress.setDistrict("tehran");
        unitAddress.setProvince("tehran");
        unitAddress.setFloor("fifth");
        unitAddress.setUnitNumber("14");
        unitAddress.setPostCode("10003334446");
        when(unitAddressService.findById(1)).thenReturn(java.util.Optional.of(unitAddress));
    }

    @Test
    void getAll() {
        UnitAddress unitAddress1 = new UnitAddress(1 , "tehran", "tehran", "gharb", "1012141010001", "one", "15");
        UnitAddress unitAddress2 = new UnitAddress(2 , "khuzestam", "bahar", "gharb", "5000087009001", "one", "15");
        List<UnitAddress> unitAddresses = new ArrayList<>();
        unitAddresses.add(unitAddress1);
        unitAddresses.add(unitAddress2);
        when(unitAddressService.findAll()).thenReturn(unitAddresses);
        ArrayList<UnitAddress> result = (ArrayList<UnitAddress>) unitAddressService.findAll();
        assert (unitAddresses.stream().count()==2);
    }

    @Test
    void update() {
        UnitAddress unitAddress= new UnitAddress();
        unitAddress.setId(1);
        unitAddress.setCity("urmia");
        unitAddress.setDistrict("tehran");
        unitAddress.setProvince("tehran");
        unitAddress.setFloor("fifth");
        unitAddress.setUnitNumber("14");
        unitAddress.setPostCode("10003334446");
        when(unitAddressService.save(unitAddress)).thenReturn(unitAddress);
    }

    @Test
    void delete() {
        doNothing().when(unitAddressService).deleteById(1);
        //unitAddressController.delete(1);
    }

        @Test
        void getPostalAddress () {
        }
    }