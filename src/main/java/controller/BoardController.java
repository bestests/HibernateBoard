package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDAO;
import service.BoardService;
import vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	BoardService service;
	@Autowired
	BoardDAO dao;

	@RequestMapping("index")
	public String boardMain(HttpServletRequest req, HttpServletResponse res) {
		return "main";
	}
	
	@RequestMapping("list")
	public Map<String, Object> list() {
		Map<String, Object> result = new HashMap<>();
		
		result.put("list", dao.selectAll());
		
		return result;
	}
	
	@RequestMapping(value="regist", method=RequestMethod.GET)
	public String registPage() {
		return "regist";
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registContent(BoardVO vo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		vo.setRegDate(sdf.format(new Date()));
		dao.insertOne(vo);
		return "redirect:http://localhost:8008/HibernateBoard/board/index.do";
	}
	
	@RequestMapping("detail")
	public String detailPage(int no) {
		return "detail";
	}
	
	@RequestMapping("detailView")
	public BoardVO detailView(int no) {
		return dao.selectOne(no);
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updatePage() {
		return "update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateOne(BoardVO vo) {
		dao.updateOne(vo);
		
		return "redirect:http://localhost:8008/HibernateBoard/board/detail.do?no=" + vo.getNo();
	}
	
	@RequestMapping("delete")
	public String delete(int no) {
		dao.deleteOne(no);
		return "redirect:http://localhost:8008/HibernateBoard/board/index.do"; 
	}
}
