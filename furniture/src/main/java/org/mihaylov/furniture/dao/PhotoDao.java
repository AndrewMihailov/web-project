package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.Photo;

@org.springframework.transaction.annotation.Transactional
public class PhotoDao extends GenericDao<Photo, Integer> {

	public PhotoDao() {
		super(Photo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Photo> searchByProductId(Integer id) {
		return (List<Photo>) hibernateTemplate.findByNamedQueryAndNamedParam("searchByProductId", "productId", id);
	}

}
