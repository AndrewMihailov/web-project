package org.mihaylov.furniture.service;

import java.util.ArrayList;
import java.util.Collection;

import org.mihaylov.furniture.dao.AdminDao;
import org.mihaylov.furniture.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("adminUserDetailsService")
public class AdminUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		Admin admin = adminDao.findByLogin(arg0);
		if (admin == null)
			throw new UsernameNotFoundException("user not found");

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(admin.getRole()));
		return new User(admin.getLogin(), admin.getPassword(), authorities);
	}

}
