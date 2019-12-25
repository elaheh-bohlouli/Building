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
public class UnitOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    @EqualsAndHashCode.Exclude
    private String name;
    @Column
    @EqualsAndHashCode.Exclude
    private String lastName;
    @Column
    private String phone;
}
