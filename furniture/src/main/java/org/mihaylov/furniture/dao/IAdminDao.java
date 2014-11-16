package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.Admin;

public interface IAdminDao {
	public void saveAdmin(Admin admin);
	public List<Admin> list();
}
