package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
@EqualsAndHashCode
public class BuildingBankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    @EqualsAndHashCode.Exclude
    private String bankName;
    @Column
    private String accountNumber;
    @Column
    private String bankCard;
    @Column
    private Long Balance;

/*    public Long getBalance() {
        return building.getBuildingBankAccount().Balance;
    }

    public void setBalance(Long balance) {
        Balance = building.getBuildingBankAccount().Balance;
    }*/

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "fk_buildingToAccount")
    private Building building;
}
