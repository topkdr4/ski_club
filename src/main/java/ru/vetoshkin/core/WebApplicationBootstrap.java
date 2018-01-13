package ru.vetoshkin.core;

import org.apache.log4j.Logger;
import ru.vetoshkin.util.PageService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;





/**
 * Ветошкин А.В. РИС-16бзу
 */
@WebListener
public class WebApplicationBootstrap implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(WebApplicationBootstrap.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            HikariPool.init();
            PageService.init();
        } catch (IOException e) {
            logger.warn("ERROR: ", e);
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
