package com.web.config;


import order.impl.OrderDAOImpl;
import order.impl.OrderManagementImpl;
import order.impl.Orders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;


/**
 * Created by W on 19.06.2014.
 */
@ComponentScan(basePackages = "com.web.controll")
@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public HashMap<String, Orders> databaseInit() {
        HashMap<String, Orders> database = new HashMap<String, Orders>();
        return database;
    }

    @Bean(name = "OrderDAOImpl")
    public OrderDAOImpl initOrderDAO() {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        orderDAO.setOrders(databaseInit());
        return orderDAO;
    }

    @Bean(name = "OrderManagementImpl")
    public OrderManagementImpl initOrderManagement() {
        OrderManagementImpl management = new OrderManagementImpl();
        management.setOrderDAO(initOrderDAO());
        return management;
    }
}
