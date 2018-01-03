package ru.vetoshkin.util;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vetoshkin.bean.Trainer;

import java.io.IOException;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Jackson {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    static {
        jsonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        jsonMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }


    private Jackson() {

    }


    public static String toJson(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }


    public static Trainer toObject(String json) throws IOException {
        return jsonMapper.readValue(json, Trainer.class);
    }

}
