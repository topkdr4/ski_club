package ru.vetoshkin.core;


import org.glassfish.jersey.server.ResourceConfig;





public class RestApplicationBootstrap extends ResourceConfig {

    public RestApplicationBootstrap() {
        packages("ru.vetoshkin.rest");
    }

}
