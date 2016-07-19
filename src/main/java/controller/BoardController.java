package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDAO;
import service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("test")
	public String boardtest() {
		return "test";
	}
	
	@RequestMapping("list")
	public String boardList(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("list", new BoardDAO().selectAll());
		return "main";
	}
}
