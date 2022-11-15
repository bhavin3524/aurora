package com.phoenix.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.support.ResourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

//@Configuration
public class HibernateConfig {

//    private Environment env;
//
//    @Autowired
//    public HibernateConfig(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//    public HibernateTemplate getHibernateTemplate() throws IOException {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate();
//        hibernateTemplate.setSessionFactory(getSessionFactory());
//        return hibernateTemplate;
//    }
//
//    @Bean
//    public SessionFactory getSessionFactory() throws IOException {
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(getDataSource());
//        localSessionFactoryBean.setPackagesToScan(env.getProperty("packagesToScan"));
//        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
//        localSessionFactoryBean.afterPropertiesSet();
//        return localSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName(env.getProperty("datasource.driver-class-name"));
//        driverManagerDataSource.setUrl(env.getProperty("datasource.url"));
//        driverManagerDataSource.setUsername(env.getProperty("datasource.username"));
//        driverManagerDataSource.setPassword(env.getProperty("datasource.password"));
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public Properties getHibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        return hibernateProperties;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTxnManager() throws IOException {
//        HibernateTransactionManager hibernateTransactionManager =
//                new HibernateTransactionManager(getSessionFactory());
//        return hibernateTransactionManager;
//    }
//
//    @Bean
//    public ResourceTransactionManager getResourceTransactionManager() throws IOException {
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(getSessionFactory());
//        return hibernateTransactionManager;
//    }
//
//


}
