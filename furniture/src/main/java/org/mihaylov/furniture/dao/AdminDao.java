package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Admin;

@org.springframework.transaction.annotation.Transactional
public class AdminDao extends GenericDao<Admin, Integer> {

	public AdminDao() {
		super(Admin.class);
	}
	
	public Admin findByLogin(String login) {
		return (Admin) hibernateTemplate.findByNamedQueryAndNamedParam("findByLogin", "login", login).get(0);
	}

}
