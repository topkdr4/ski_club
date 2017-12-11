package ru.vetoshkin;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Applic extends Application {

    @Override public Set<Class<?>> getClasses() {
        Set<Class<?>> sets = new HashSet<>();
        sets.add(Test.class);
        return sets;
    }
}
