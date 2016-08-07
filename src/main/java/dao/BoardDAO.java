package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import util.HibernateUtil;
import vo.BoardVO;
import vo.CommentVO;

@Component
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
		Criteria criteria = session.createCriteria(BoardVO.class);
		criteria.addOrder(Order.desc("no"));
		List<BoardVO> list = criteria.list();
		/*
		Query query = session.createQuery("from BoardVO");
		List<BoardVO> list = query.getResultList();
		*/
		session.getTransaction().commit();
		return list;
	}
	
	public void insertOne(BoardVO vo) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(vo);
		
		session.getTransaction().commit();
	}
	
	public BoardVO selectOne(int no) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BoardVO.class);
		criteria.add(Restrictions.eq("no", no));
		
		BoardVO vo = (BoardVO)criteria.uniqueResult();
		
		session.getTransaction().commit();
		
		return vo;
	}
	
	public void updateOne(BoardVO vo) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(vo);
		
		session.getTransaction().commit();
	}
	
	public void deleteOne(int no) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.delete(session.get(BoardVO.class, no));
		
		session.getTransaction().commit();
	}
	
	public List<CommentVO> selectCommentAll(int boardNo) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(CommentVO.class);
		criteria.add(Restrictions.eqOrIsNull("boardNo", boardNo));
		criteria.addOrder(Order.desc("no"));
		
		List<CommentVO> list = criteria.list();
		
		session.getTransaction().commit();
		
		return list;
	}
	
	public CommentVO insertComment(CommentVO cVo) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		CommentVO vo = session.get(CommentVO.class, session.save(cVo));
		
		session.getTransaction().commit();
		
		return vo;
	}
}
