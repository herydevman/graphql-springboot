package com.jpapostgresql.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="plat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String categorie;

    private String image;
}
