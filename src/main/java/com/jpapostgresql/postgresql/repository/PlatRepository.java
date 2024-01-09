package com.jpapostgresql.postgresql.repository;

import com.jpapostgresql.postgresql.entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Integer> {
    public List<Plat> findByCategorie(String categorie);
    public Plat findByName(String name);
}
