package com.example.model.dao;

import com.example.HibernateUtil;
import com.example.model.dao.impl.VideoDaoHibernate;

public class DaoFactory {
	
	public static VideoDaoHibernate createVideoDao() {
		return new VideoDaoHibernate(HibernateUtil.getSessionFactory().openSession());
	}
}
