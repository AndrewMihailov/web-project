package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Designer;

@org.springframework.transaction.annotation.Transactional
public class DesignerDao extends GenericDao<Designer, Integer> {

	public DesignerDao() {
		super(Designer.class);
	}
}
