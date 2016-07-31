package vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HIBERNATE_BOARD") 
public class BoardVO {
	@Id
	@GeneratedValue
	@Column(name="BOARD_NO")
	int no;	
	@Column(name="BOARD_TITLE")
	String title;
	@Column(name="BOARD_CONTENT")
	String content;
	@Column(name="BOARD_WRITER")
	String writer;
	@Column(name="BOARD_REG_DATE")
	String regDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
