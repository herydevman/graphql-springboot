package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.Plat;

import java.util.List;

public interface PlatService {

    public Plat save(Plat user);
    public List<Plat> getAllPlats();

    public Plat getOnePlat(String name);

    public Plat platById(int id);

    public String deletePlat(int id);

    public List<Plat> findManyPlats(String categorie);

    Plat updatePlat(int id, Plat plat);
}
