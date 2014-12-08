package org.mihaylov.furniture.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class GenericDao<T, PK extends Serializable> {

	@Autowired
	protected HibernateTemplate hibernateTemplate;
	private Class<T> type;
	
	public GenericDao(Class<T> type) {
		this.type = type;
	}
	
	@SuppressWarnings("unchecked")
	public PK save(T o) {
		return (PK) hibernateTemplate.save(o);
	}
	
	public T load(PK id) {
		return hibernateTemplate.get(type, id);
	}
	
	public void update(T o) {
		hibernateTemplate.update(o);
    }

    public void delete(T o) {
    	hibernateTemplate.delete(o);
    }
    
    public List<T> list() {
    	return hibernateTemplate.loadAll(type);
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
