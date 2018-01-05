package ru.vetoshkin.core;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;





public class RestApplicationBootstrap extends ResourceConfig {

    public RestApplicationBootstrap() {
        super(
                ObjectMapperProvider.class,
                JacksonFeature.class
        );
        packages("ru.vetoshkin.rest");
    }

}
