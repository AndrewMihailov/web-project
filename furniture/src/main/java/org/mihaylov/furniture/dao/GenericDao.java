package org.mihaylov.furniture.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
    
    public Integer count() {
    	DetachedCriteria criteria = DetachedCriteria.forClass(type)
				.setProjection(Projections.rowCount());
		return ((Long) hibernateTemplate.findByCriteria(criteria).get(0)).intValue();
    }
    
	@SuppressWarnings("unchecked")
	public List<T> list(Integer first, Integer limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(type)
				.addOrder(Order.desc("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<T>) hibernateTemplate.findByCriteria(criteria, first, limit);
		/*
    	return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				Query q = session.createQuery(String.format("from %s", type.getSimpleName()));
				q.setFirstResult(first);
                q.setMaxResults(limit);
                return (List<T>) q.list();
			}
        });*/
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
