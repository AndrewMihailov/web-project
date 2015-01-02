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
	public List<Photo> list(Integer first, Integer limit) {
		return photoDao.list(first, limit == null ? 5 : limit);
	}
	
	@Transactional
	public Integer count() {
		return photoDao.count();
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
		photo.setImage(oldImg);
		if (image != null && !image.isEmpty() && oldImg == null) {
			photo.setImage(savePhoto(image));
		}
		photoDao.update(photo);
	}
	
	private String savePhoto(MultipartFile file) throws IOException {
		return FileSystemUtils.saveMultipart(file, "photo");
	}
	
	public void deleteOldImage(Integer id) {
		FileSystemUtils.deleteFile(load(id).getImage());
	}
}
