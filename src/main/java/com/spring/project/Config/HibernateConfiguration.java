package com.spring.project.Config;


import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.spring.project.Data.Address;
import com.spring.project.Data.Author;
import com.spring.project.Data.Book;
import com.spring.project.Data.CarteBancaire;
import com.spring.project.Data.Comment;
import com.spring.project.Data.Contact;
import com.spring.project.Data.Customer;
import com.spring.project.Data.Order;
import com.spring.project.Data.OrderDetails;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
 
@Configuration
@EnableTransactionManagement
//@ComponentScan(value={"com.spring.project.Data"})
@ComponentScan(basePackages = "com.spring.project.Data , com.spring.project")
//@ImportResource("classpath:spring-config.xml")
public class HibernateConfiguration {
    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.spring.project.Data" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
     }
     
    @Bean(name = "dataSource")
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jebouquine");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.hbm2ddl.auto","update");
        return properties;        
    }
     
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
    
    @Bean
    public GenericDaoImpl<Book> getBookService(){
        return new GenericDaoImpl<Book>(Book.class);
    }

    @Bean
    public GenericDaoImpl<Author> getAuthorService(){
        return new GenericDaoImpl<Author>(Author.class);
    }
    @Bean
    public GenericDaoImpl<CarteBancaire> getCarteBancaireService(){
        return new GenericDaoImpl<CarteBancaire>(CarteBancaire.class);
    }
    @Bean
    public GenericDaoImpl<Address> getAddressService(){
        return new GenericDaoImpl<Address>(Address.class);
    }
    @Bean
    public GenericDaoImpl<Customer> getCustomerService(){
        return new GenericDaoImpl<Customer>(Customer.class);
    }
    @Bean
    public GenericDaoImpl<Order> getOrderService(){
        return new GenericDaoImpl<Order>(Order.class);
    }
    @Bean
    public GenericDaoImpl<OrderDetails> getOrderDetailsService(){
        return new GenericDaoImpl<OrderDetails>(OrderDetails.class);
    }
    @Bean
    public GenericDaoImpl<Comment> getCommentService(){
        return new GenericDaoImpl<Comment>(Comment.class);
    }
    @Bean
    public GenericDaoImpl<Contact> getContactService(){
        return new GenericDaoImpl<Contact>(Contact.class);
    }
   
}