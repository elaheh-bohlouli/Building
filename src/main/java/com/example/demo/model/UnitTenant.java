package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table
@EqualsAndHashCode
@AllArgsConstructor
public class UnitTenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    @EqualsAndHashCode.Exclude
    private int tenantNumber;
    @Column
    @EqualsAndHashCode.Exclude
    private String name;
    @Column
    private String lastName;
    @Column
    private String phone;
}
