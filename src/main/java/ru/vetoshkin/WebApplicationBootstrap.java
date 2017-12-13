package ru.vetoshkin;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Ветошкин А.В. РИС-16бзу
 */
@WebListener
public class WebApplicationBootstrap implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
