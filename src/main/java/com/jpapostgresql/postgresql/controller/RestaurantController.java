package com.jpapostgresql.postgresql.controller;


import com.jpapostgresql.postgresql.entity.Restaurant;
import com.jpapostgresql.postgresql.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @QueryMapping(name="queryRestaurants")
    public List<Restaurant> findAllRestaurant(){
        return restaurantService.findAllRestaurant();
    }

    @QueryMapping(name="restaurantById")
    public Restaurant findOneById(@Argument int id){
        return restaurantService.findRestaurantById(id);
    }

    @QueryMapping(name="findByCity")
    public List<Restaurant> findByCity(@Argument String city){
        return restaurantService.findByCity(city);
    }

    @QueryMapping(name="findByCountry")
    public List<Restaurant> findByCountry(@Argument String country){
        return restaurantService.findByCountry(country);
    }

    @QueryMapping(name="findByLevelstar")
    public List<Restaurant> findByLevelstart(@Argument String levelstar){
        return restaurantService.findByLevelstar(levelstar);
    }

    @MutationMapping(name="createRestaurant")
    public Restaurant createRestaurant(
            @Argument String name,
            @Argument int levelstar,
            @Argument String address,
            @Argument String city,
            @Argument String country,
            @Argument String image
    ){
        Restaurant restaurant = new Restaurant().builder()
                .name(name)
                .address(address)
                .levelstar(levelstar)
                .city(city)
                .country(country)
                .image(image)
                .build();
        return restaurantService.createRestaurant(restaurant);
    }

    @MutationMapping(name="updateRestaurant")
    public Restaurant updateRestaurant(
            @Argument int id,
            @Argument String name,
            @Argument int levelstar,
            @Argument String address,
            @Argument String city,
            @Argument String country,
            @Argument String image
    ){
        Restaurant restaurant = new Restaurant().builder()
                .name(name)
                .address(address)
                .levelstar(levelstar)
                .city(city)
                .country(country)
                .image(image)
                .build();
        return restaurantService.updateRestaurant(id, restaurant);
    }
}
