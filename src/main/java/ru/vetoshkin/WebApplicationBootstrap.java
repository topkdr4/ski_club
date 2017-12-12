package ru.vetoshkin;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@WebListener
public class WebApplicationBootstrap implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(Arrays.asList(Test.class));
        factoryBean.create();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
