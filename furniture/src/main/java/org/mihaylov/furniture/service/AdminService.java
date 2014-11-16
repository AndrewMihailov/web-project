package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.IAdminDao;
import org.mihaylov.furniture.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;
	
	@Transactional
	public void addAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
	}

	@Transactional
	public List<Admin> listAdmin() {
		return adminDao.list();
	}

	@Transactional
	public void removeAdmin(Integer id) {
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
