package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.entity.Admin;

public interface IAdminService {

	public void addAdmin(Admin admin);
	public List<Admin> listAdmin();
	public void removeAdmin(Integer id);
	
}
