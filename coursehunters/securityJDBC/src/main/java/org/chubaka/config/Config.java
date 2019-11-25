package org.chubaka.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.chubaka")
@PropertySource("classpath:jdbc.properties")
public class Config {

    @Autowired
    Environment config;

    //define bean for viewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/view/");
        return viewResolver;
    }

    //define been for datasource
    @Bean
    public DataSource securityDataSource() {

        BasicDataSource securityDataSource = new BasicDataSource();
        securityDataSource.setDriverClassName(config.getProperty("driver-class-name"));
        securityDataSource.setUrl(config.getProperty("url"));
        securityDataSource.setUsername("postgres");
        securityDataSource.setPassword(config.getProperty("password"));
        securityDataSource.setMinIdle(5);
        securityDataSource.setMaxIdle(10);
        securityDataSource.setMaxOpenPreparedStatements(100);

        //test
        System.out.println("!!!!!!!!!");
        System.out.println(config.getProperty("url"));
        System.out.println(config.getProperty("username"));
        System.out.println(config.getProperty("password"));
        System.out.println("!!!!!!!!!!");

        try {
            Connection connection = securityDataSource.getConnection();
            System.out.println(connection.getSchema() + " " + connection.getMetaData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  securityDataSource;
    }

    //helper method
    private int getIntProperty(String name) {
        String prop = config.getProperty(name);
        return Integer.parseInt(prop);
    }
}
