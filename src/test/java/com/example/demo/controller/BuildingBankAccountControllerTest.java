package com.example.demo.controller;

import com.example.demo.commen.ItemNotFound;
import com.example.demo.model.Building;
import com.example.demo.model.BuildingBankAccount;
import com.example.demo.service.BuildingBankAccountService;
import org.junit.Before;
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
@WebMvcTest(BuildingBankAccountController.class)
class BuildingBankAccountControllerTest {

    @Mock
    BuildingBankAccountService buildingBankAccountService;

    @MockBean
    BuildingBankAccountController buildingBankAccountController;
    BuildingBankAccount buildingBankAccount;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
    //    MockHttpServletRequest request = new MockHttpServletRequest();
   //     RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(buildingBankAccountService.save(any(BuildingBankAccount.class))).thenReturn(buildingBankAccount);
        BuildingBankAccount buildingBankAccount = new BuildingBankAccount(1, "melli",
                "10014", "6219861030434343", 1000L, new Building());
        assert (buildingBankAccount.getAccountNumber()).equals("10014");
        assert (buildingBankAccount.getBankCard()).equals("6219861030434343");
    }

    @Test
    void getById() {
        BuildingBankAccount buildingBankAccount= new BuildingBankAccount();
        buildingBankAccount.setId(1);
        buildingBankAccount.setBalance(1000L);
        buildingBankAccount.setBankCard("54364715724");
        buildingBankAccount.setAccountNumber("35423156587087");
        buildingBankAccount.setBankName("mellate");
        buildingBankAccount.setBuilding(new Building());
        when(buildingBankAccountService.findById(1)).thenReturn(java.util.Optional.of(buildingBankAccount));
    }

    @Test
    void getAll() {
        BuildingBankAccount buildingBankAccount1 = new BuildingBankAccount(1, "mellat",
                "10014","6219861030434343", 1000L, new Building());
        BuildingBankAccount buildingBankAccount2 = new BuildingBankAccount(2, "meli",
                "1000014","621986103000000000", 10L, new Building());
        List<BuildingBankAccount> buildingBankAccounts = new ArrayList<>();
        buildingBankAccounts.add(buildingBankAccount1);
        buildingBankAccounts.add(buildingBankAccount2);
        when(buildingBankAccountService.findAll()).thenReturn(buildingBankAccounts);
        ArrayList<BuildingBankAccount> result = (ArrayList<BuildingBankAccount>) buildingBankAccountService.findAll();
        assert (buildingBankAccounts.get(0).getBankName()).equals("mellat");
        assert (buildingBankAccounts.get(1).getBankName()).equals("meli");
        assert (buildingBankAccounts.stream().count()==2);
    }

    @Test
    void update() {
            BuildingBankAccount buildingBankAccount= new BuildingBankAccount();
            buildingBankAccount.setId(1);
            buildingBankAccount.setBalance(1000L);
            buildingBankAccount.setBankCard("54364715724");
            buildingBankAccount.setAccountNumber("35423156587087");
            buildingBankAccount.setBankName("mellate");
            buildingBankAccount.setBuilding(new Building());
            when(buildingBankAccountService.save(buildingBankAccount)).thenReturn(buildingBankAccount);
    }

    @Test
    void delete() throws ItemNotFound {
        doNothing().when(buildingBankAccountService).deleteById(1);
        buildingBankAccountController.delete(1);
    }
}