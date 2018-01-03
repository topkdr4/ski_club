package ru.vetoshkin.core;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.vetoshkin.util.PropertiesUtil;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class HikariPool {

    private static final String propertiesLocation = "db.properties";
    private static DataSource source;


    public static void init() throws IOException {
        Properties dbProperties = PropertiesUtil.loadProperties(propertiesLocation);

        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(dbProperties.getProperty("db.host"));
        configuration.setUsername(dbProperties.getProperty("db.user"));
        configuration.setPassword(dbProperties.getProperty("db.password"));
        configuration.setCatalog(dbProperties.getProperty("db.catalog"));
        configuration.setMaximumPoolSize(15);
        configuration.setAutoCommit(true);

        source = new HikariDataSource(configuration);
    }


    public static DataSource getSource() {
        return source;
    }

}
