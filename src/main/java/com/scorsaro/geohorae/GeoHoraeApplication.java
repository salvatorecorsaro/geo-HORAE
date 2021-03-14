package com.scorsaro.geohorae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GeoHoraeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoHoraeApplication.class, args);
    }

}
