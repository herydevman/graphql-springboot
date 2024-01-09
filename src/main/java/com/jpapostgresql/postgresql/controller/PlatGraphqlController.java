package com.jpapostgresql.postgresql.controller;

import com.jpapostgresql.postgresql.entity.Plat;
import com.jpapostgresql.postgresql.services.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatGraphqlController {

    @Autowired
    private PlatService platService;

    @QueryMapping(name="queryPlats")
    public List<Plat> getAllPlats(){
        return this.platService.getAllPlats();
    }

    @QueryMapping(name="findOnePlat")
    public Plat findOnePlat(@Argument String name){
        return this.platService.getOnePlat(name);
    }

    @QueryMapping(name="platById")
    public Plat platById(@Argument int id){
        return this.platService.platById(id);
    }

    @QueryMapping(name="findManyPlats")
    public List<Plat> findManyPlats(@Argument String categorie){
        return this.platService.findManyPlats(categorie);
    }


    @MutationMapping(name="createPlat")
    public Plat createPlat(@Argument String name, @Argument String description,  @Argument String categorie, @Argument String image){
        Plat plat = new Plat().builder()
                .name(name)
                .description(description)
                .categorie(categorie)
                .image(image)
                .build();
        return this.platService.save(plat);
    }

    @MutationMapping(name="updatePlat")
    public Plat updatePlat(
            @Argument int id,
            @Argument String name,
            @Argument String description,
            @Argument String categorie,
            @Argument String image){
        Plat plat = new Plat().builder()
                .name(name)
                .description(description)
                .categorie(categorie)
                .image(image)
                .build();
        return this.platService.updatePlat(id,plat);
    }

}
