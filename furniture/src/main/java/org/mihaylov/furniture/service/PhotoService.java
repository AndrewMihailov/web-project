package org.mihaylov.furniture.service;

import java.io.IOException;
import java.util.List;

import org.mihaylov.furniture.dao.PhotoDao;
import org.mihaylov.furniture.entity.Photo;
import org.mihaylov.furniture.utils.FileSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("photoService")
public class PhotoService {

	@Autowired
	private PhotoDao photoDao;

	@Transactional
	public void save(Photo photo) {
		photoDao.save(photo);
	}

	@Transactional
	public void save(Photo photo, MultipartFile image) throws IOException {
		photo.setImage(savePhoto(image));
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
	public Photo load(Integer id) {
		return photoDao.load(id);
	}
	
	@Transactional
	public List<Photo> searchByProductId(Integer id) {
		return photoDao.searchByProductId(id);
	}

	@Transactional
	public void update(Photo photo) {
		photoDao.update(photo);
	}

	@Transactional
	public void update(Photo photo, MultipartFile image, String oldImg)
			throws IOException {
		if (oldImg != null) {
			photo.setImage(oldImg);
		} else if (image != null) {
			photo.setImage(savePhoto(image));
		}
		photoDao.update(photo);
	}
	
	private String savePhoto(MultipartFile file) throws IOException {
		return FileSystemUtils.saveMultipart(file, "photo");
	}
}
