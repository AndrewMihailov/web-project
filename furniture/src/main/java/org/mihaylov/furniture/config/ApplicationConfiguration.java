package org.mihaylov.furniture.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.mihaylov.furniture.dao.AdminDao;
import org.mihaylov.furniture.dao.IAdminDao;
import org.mihaylov.furniture.dao.NewsDao;
import org.mihaylov.furniture.entity.Admin;
import org.mihaylov.furniture.service.AdminService;
import org.mihaylov.furniture.service.IAdminService;
import org.mihaylov.furniture.service.NewsService;
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
	public IAdminService adminService() {
		return new AdminService();
	}

	@Bean
	public IAdminDao adminDao() {
		return new AdminDao();
	}
	
	@Bean
	public NewsService newsService() {
		return new NewsService();
	}

	@Bean
	public NewsDao newsDao() {
		return new NewsDao();
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
