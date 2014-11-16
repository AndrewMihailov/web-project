package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

@org.springframework.transaction.annotation.Transactional
public class AdminDao implements IAdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void saveAdmin(Admin admin) {
		hibernateTemplate.save(admin);
	}

	public List<Admin> list() {
		return hibernateTemplate.loadAll(Admin.class);
	}

}
