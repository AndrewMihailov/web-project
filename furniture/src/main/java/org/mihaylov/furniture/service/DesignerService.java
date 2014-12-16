package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.DesignerDao;
import org.mihaylov.furniture.entity.Designer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("designerService")
public class DesignerService {
	
	@Autowired
	private DesignerDao designerDao;
	
	@Transactional
	public void save(Designer designer) {
		designerDao.save(designer);
	}

	@Transactional
	public List<Designer> list() {
		return designerDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		designerDao.delete(designerDao.load(id));
	}
	
	@Transactional
	public void update(Designer designer) {
		designerDao.update(designer);
	}
	
	@Transactional
	public Designer load(Integer id) {
		return designerDao.load(id);
	}
}
