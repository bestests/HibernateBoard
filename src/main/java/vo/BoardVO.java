package vo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="HIBERNATE_BOARD") 
public class BoardVO {
	@Id
	@SequenceGenerator(name="SEQ_BOARD_NO", sequenceName="SEQ_BOARD_NO", allocationSize=7)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_BOARD_NO")
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
	
	@OneToMany
	@JoinColumn(name="BOARD_NO")
	List<CommentVO> comments;
	
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
