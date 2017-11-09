package br.com.cdw.cliente.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/* Será usado pelo Spring para gerar o EntityManager. 
Este precisa de um adapter e estamos passando um que o Hibernate disponibiliza.*/

/*@EnableTransactionManagement faz com que o Spring ative o gerenciamento de transações e já reconhece o TransactionManager */
@EnableTransactionManagement
public class JPAConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);
        
        // DataSource contém as configurações de banco de dados. 
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/clubedowhisky");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        factoryBean.setDataSource(dataSource);
        
        /*Properties para podermos setar algumas configurações, como por exemplo o dialeto usado para a comunicação 
         com o banco de dados. Setamos também onde o EntityManager encontrará nossos Models. 
         Feito isso retornamos nossas configurações para o Spring poder utiliza-las.*/
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("br.com.cdw.models");

        return factoryBean;
    }
    
    /*TransactionManager que conheça nosso EntityManager para que assim ele possa gerenciar as transações de nossas entidades*/
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
