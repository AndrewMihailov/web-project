package org.mihaylov.furniture.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminCommon {

	protected void init(ModelAndView model) {
		Collection<? extends GrantedAuthority> authorities;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			authorities = ((UserDetails) principal).getAuthorities();
			
			model.addObject("admin_role", authorities.iterator().next().getAuthority());
		}
	}
}
