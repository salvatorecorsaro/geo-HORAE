package com.scorsaro.geohorae.config;


import com.scorsaro.geohorae.entity.Country;
import com.scorsaro.geohorae.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;


@Configuration
public class RestConfig implements RepositoryRestConfigurer {
    private EntityManager entityManager;

    @Autowired
    public RestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(Region.class, config, theUnsupportedActions);


    }

    private void disableHttpMethods(Class targetClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(targetClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }


}
