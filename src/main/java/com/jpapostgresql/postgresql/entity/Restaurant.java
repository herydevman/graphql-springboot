package com.jpapostgresql.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer levelstar;

    private String address;

    private String city;

    private String country;

    private String image;
}
