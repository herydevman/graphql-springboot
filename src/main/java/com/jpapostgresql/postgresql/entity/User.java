package com.jpapostgresql.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    private String payementway;


    private boolean islogged;
}
