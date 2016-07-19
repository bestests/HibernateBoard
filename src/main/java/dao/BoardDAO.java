package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import util.HibernateUtil;
import vo.BoardVO;

public class BoardDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	/*
	public BoardDAO() {
		session = factory.getCurrentSession();
		session.beginTransaction();
	}
	
	public void setTable() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		BoardVO board = new BoardVO();
		board.setNo(1);
		board.setTitle("testTitle");
		board.setWriter("tester");
		board.set
		
		session.save(m);
		
		session.getTransaction().commit();
	}
	 */
	
	public List<BoardVO> selectAll() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from BoardVO");
		List<BoardVO> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}
}
