package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import vo.BoardVO;
import vo.CommentVO;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			Configuration cfg = new Configuration().configure("hibernate.config.xml");
			cfg.addAnnotatedClass(BoardVO.class);
			cfg.addAnnotatedClass(CommentVO.class);
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void shutdown() {
		sessionFactory.close();
	}
}
