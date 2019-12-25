package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table
@EqualsAndHashCode
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    @EqualsAndHashCode.Exclude
    private String buildingName;
    @Column
    private String buildingAddress;
    @Column
    private String manager;
    @Column
    private Integer numberOfUnits;
    @Column
    private String phone;
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    Set<Unit> unitHashSets = new HashSet<>();
}
