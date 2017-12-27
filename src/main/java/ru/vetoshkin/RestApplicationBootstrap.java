package ru.vetoshkin;


import ru.vetoshkin.rest.TrainerRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplicationBootstrap extends Application {

    private static final Set<Object> singletons = new HashSet<>();

    static {
        singletons.add(new TrainerRestService());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}