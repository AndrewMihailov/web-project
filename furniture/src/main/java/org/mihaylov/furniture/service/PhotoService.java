package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.PhotoDao;
import org.mihaylov.furniture.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("photoService")
public class PhotoService {

	@Autowired
	private PhotoDao photoDao;

	@Transactional
	public void save(Photo photo) {
		photoDao.save(photo);
	}

	@Transactional
	public List<Photo> list() {
		return photoDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		photoDao.delete(photoDao.load(id));
	}
	
	@Transactional
	public Photo get(Integer id) {
		return photoDao.load(id);
	}
}
