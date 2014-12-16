package org.mihaylov.furniture.config;

import org.mihaylov.furniture.service.AdminUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AdminUserDetailsService adminUserDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(adminUserDetailsService);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() /* В порядке убывания важности */
		.antMatchers("/admin/admin-editor", "/admin/add-admin")
				.access("hasRole('SUPER')").antMatchers("/admin/**")
				.access("hasRole('ADMIN') or hasRole('SUPER')")
				.antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/login").permitAll()
				.and().logout()
                .logoutSuccessUrl("/login?logout").logoutUrl("/logout")
				.and().csrf().disable()
				;
	}
	
	@Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManager();
    }
/*
	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {
		@Autowired
		private AdminUserDetailsService adminUserDetailsService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
			daoAuthenticationProvider
					.setUserDetailsService(adminUserDetailsService);
			auth.authenticationProvider(daoAuthenticationProvider);
		}

		public AdminUserDetailsService getAdminUserDetailsService() {
			return adminUserDetailsService;
		}

		public void setAdminUserDetailsService(
				AdminUserDetailsService adminUserDetailsService) {
			this.adminUserDetailsService = adminUserDetailsService;
		}
	}*/
}
