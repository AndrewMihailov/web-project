package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Contact;

@org.springframework.transaction.annotation.Transactional
public class ContactDao extends GenericDao<Contact, Integer> {

	public ContactDao() {
		super(Contact.class);
	}

}
