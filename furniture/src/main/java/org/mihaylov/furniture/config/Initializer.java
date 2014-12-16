package org.mihaylov.furniture.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		 
        ctx.register(WebMvcConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
 
        ctx.setServletContext(servletContext);
 
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", 
                                                                        new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        servlet.setMultipartConfig(new MultipartConfigElement("C:\\tmp",
				1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));
		
	}

}
