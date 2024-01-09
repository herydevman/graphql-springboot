package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.Plat;
import com.jpapostgresql.postgresql.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatServiceImpl implements PlatService{

    @Autowired
    private PlatRepository platRepository;

    @Override
    public Plat save(Plat plat) {
        return this.platRepository.save(plat);
    }

    @Override
    public List<Plat> getAllPlats() {
        return this.platRepository.findAll();
    }

    @Override
    public Plat getOnePlat(String name) {
        return this.platRepository.findByName(name);
    }

    @Override
    public Plat platById(int id) {
        return this.platRepository.findById(id).get();
    }

    @Override
    public String deletePlat(int id) {
        this.platRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public List<Plat> findManyPlats(String categorie) {
        return this.platRepository.findByCategorie(categorie);
    }

    @Override
    public Plat updatePlat(int id, Plat plat) {

        Plat platToUpdated = this.platRepository.findById(id).get();

        platToUpdated.setName(plat.getName());
        platToUpdated.setCategorie(plat.getCategorie());
        platToUpdated.setDescription(plat.getDescription());
        platToUpdated.setImage(plat.getImage());
        return this.platRepository.save(platToUpdated);
    }
}
