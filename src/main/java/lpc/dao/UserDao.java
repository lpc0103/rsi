package lpc.dao;

import org.springframework.stereotype.Repository;

import lpc.model.UapUser;

@Repository("userDao")
public class UserDao extends CommonHibernateDao<UapUser> {

}
