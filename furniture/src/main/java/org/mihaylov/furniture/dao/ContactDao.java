package org.mihaylov.furniture.dao;

import java.util.List;

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

}
