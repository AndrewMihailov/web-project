package org.mihaylov.furniture.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mihaylov.furniture.entity.Contact;

@org.springframework.transaction.annotation.Transactional
public class ContactDao extends GenericDao<Contact, Integer> {

	public ContactDao() {
		super(Contact.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> selectByLocale(String lang) {
		return (List<Contact>) hibernateTemplate.findByNamedQueryAndNamedParam("selectContactsByLocale", "lang", lang);
	}
	
	public Integer count(String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Contact.class).add(Restrictions.eq("lang", lang))
				.setProjection(Projections.rowCount());
		return ((Long) hibernateTemplate.findByCriteria(criteria).get(0)).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> selectDiapasonByLocale(Integer first, Integer limit, String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Contact.class).add(Restrictions.eq("lang", lang))
				.addOrder(Order.desc("id"));
		return (List<Contact>) hibernateTemplate.findByCriteria(criteria, first, limit);
	}

}
