package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.AdminDao;
import org.mihaylov.furniture.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Transactional
	public void save(Admin admin) {
		adminDao.save(admin);
	}

	@Transactional
	public List<Admin> list() {
		return adminDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		adminDao.delete(adminDao.load(id));
	}
	
	@Transactional
	public Admin load(Integer id) {
		return adminDao.load(id);
	}
	
	@Transactional
	public void update(Admin admin) {
		adminDao.update(admin);
	}

}
