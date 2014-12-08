package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Photo;

@org.springframework.transaction.annotation.Transactional
public class PhotoDao extends GenericDao<Photo, Integer> {

	public PhotoDao() {
		super(Photo.class);
	}

}
