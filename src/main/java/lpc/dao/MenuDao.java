package lpc.dao;

import lpc.model.UapMenuResource;

import org.springframework.stereotype.Repository;

@Repository(value="menuDao")
public class MenuDao extends CommonHibernateDao<UapMenuResource>{

}
