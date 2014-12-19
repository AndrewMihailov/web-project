package org.mihaylov.furniture.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import org.mihaylov.furniture.dao.NewsDao;
import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.utils.FileSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("newsService")
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public void save(News news) {
		newsDao.save(news);
	}
	
	@Transactional
	public void save(News news, MultipartFile image) throws IOException {
		if (!image.isEmpty())
			news.setImage(saveImage(image));
		news.setDate(new Date(new java.util.Date().getTime()));
		newsDao.save(news);
	}

	@Transactional
	public List<News> list() {
		return newsDao.list();
	}
	
	@Transactional
	public List<News> list(Locale locale) {
		return newsDao.selectByLocale(locale.toString());
	}

	@Transactional
	public void delete(Integer id) {
		newsDao.delete(newsDao.load(id));
	}
	
	public News load(Integer id) {
		return newsDao.load(id);
	}
	
	@Transactional
	public void update(News news) {
		newsDao.update(news);
	}
	
	@Transactional
	public void update(News news, MultipartFile image, String oldImg)
			throws IOException {
		news.setImage(oldImg);
		if (image != null && !image.isEmpty() && oldImg == null) {
			news.setImage(saveImage(image));
		}
		news.setDate(new Date(new java.util.Date().getTime()));
		newsDao.update(news);
	}
	
	private String saveImage(MultipartFile file) throws IOException {
		return FileSystemUtils.saveMultipart(file, "news");
	}

	public void deleteOldImage(Integer id) {
		FileSystemUtils.deleteFile(load(id).getImage());
	}
}
