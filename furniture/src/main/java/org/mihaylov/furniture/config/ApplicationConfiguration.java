package org.mihaylov.furniture.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.mihaylov.furniture.dao.AdminDao;
import org.mihaylov.furniture.dao.CategoryDao;
import org.mihaylov.furniture.dao.ContactDao;
import org.mihaylov.furniture.dao.DesignerDao;
import org.mihaylov.furniture.dao.NewsDao;
import org.mihaylov.furniture.dao.OfferDao;
import org.mihaylov.furniture.dao.PhotoDao;
import org.mihaylov.furniture.dao.ProductDao;
import org.mihaylov.furniture.entity.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ApplicationConfiguration {

	@Bean
	public AdminDao adminDao() {
		return new AdminDao();
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDao();
	}
	
	@Bean
	public PhotoDao photoDao() {
		return new PhotoDao();
	}
	
	@Bean
	public ContactDao contactDao() {
		return new ContactDao();
	}

	@Bean
	public OfferDao offerDao() {
		return new OfferDao();
	}

	@Bean
	public NewsDao newsDao() {
		return new NewsDao();
	}

	@Bean
	public CategoryDao categoryDao() {
		return new CategoryDao();
	}

	@Bean
	public DesignerDao designerDao() {
		return new DesignerDao();
	}

	private Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return prop;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/furniture");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(
				dataSource());
		builder.scanPackages("org.mihaylov.furniture.entity");
		builder.addAnnotatedClass(Admin.class);
		builder.addProperties(hibernateProperties());

		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

}
