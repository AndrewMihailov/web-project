package org.mihaylov.furniture.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({ "org.mihaylov.furniture.config",
		"org.mihaylov.furniture.controller", "org.mihaylov.furniture.dao",
		"org.mihaylov.furniture.entity", "org.mihaylov.furniture.service" })
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("admin/login");
		registry.addViewController("/static").setViewName("upload_test");
		registry.addViewController("/path").setViewName("path");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/* i18n */

	@Bean
	public LocaleResolver localeResolver() {
		final CookieLocaleResolver ret = new CookieLocaleResolver();
		ret.setDefaultLocale(new Locale("en_US"));
		return ret;
	}

	@Bean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
		ret.setBasename("classpath:messages");
		ret.setDefaultEncoding("UTF-8");
		return ret;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		return new CookieLocaleResolver();
	}
}
