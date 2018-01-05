package ru.vetoshkin.core;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper defaultObjectMapper = createDefaultMapper();


    public ObjectMapperProvider() {
    }


    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.enable(SerializationFeature.INDENT_OUTPUT);
        return result;
    }


    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return defaultObjectMapper;
    }

}
