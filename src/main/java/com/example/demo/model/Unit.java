package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table
@AllArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    private long area;
    @Column
    private long ChargeAmount;
    @Column
    private long UnitNumber;
    @OneToOne
    @JoinColumn(name = "fk_UnitTenant")
    @Autowired
    private UnitTenant unitTenant;
    @OneToOne
    @JoinColumn(name = "fk_address")
    @Autowired
    private UnitAddress unitAddress;
    @ManyToOne
    @JoinColumn(name = "fk_unitOwner")
    @Autowired
    private UnitOwner unitOwner;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_building")
    @Autowired
    private Building building;

}
