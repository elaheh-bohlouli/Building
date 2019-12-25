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
public class UnitAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @EqualsAndHashCode.Exclude
    private int id;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String district;
    @Column
    private String postCode;
    @Column
    private String floor;
    @Column
    private String unitNumber;

    public String getPostAddress() {
        return this.unitNumber+" Number, floor: "+ this.floor+", postCode:"+ this.postCode+", district:"+this.district+
                ", city:"+this.city+", province:"+this.province;
    }
/*    public void setPostAddress(String PostAddress) {
        String[] parts =PostAddress.split(" ");
        this.unitNumber = parts[0];
        this.floor = parts[1];
        this.postCode = parts[2];
        this.district = parts[3];
        this.city = parts[4];
        this.province = parts[5];
    }*/
}
