package org.mihaylov.furniture.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() /* В порядке убывания важности */
		.antMatchers("/admin/admin-editor", "/admin/add-admin")
				.access("hasRole('ROLE_SUPER')").antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
				.antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll()
				.and().csrf().disable()
				;
	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {

		@Autowired
		DataSource dataSource;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("admin").password("admin")
					.roles("ADMIN");
			auth.inMemoryAuthentication().withUser("super").password("super")
					.roles("SUPER");
			// TODO database authentication
			//auth.jdbcAuthentication().dataSource(dataSource);
		}

	}

}
