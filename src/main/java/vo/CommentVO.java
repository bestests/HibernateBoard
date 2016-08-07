package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIBERNATE_COMMENT")
public class CommentVO {
	@Id
	@SequenceGenerator(name="SEQ_COMMENT_NO", sequenceName="SEQ_COMMENT_NO", allocationSize=7)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMMENT_NO")
	@Column(name="COMMENT_NO")
	int no;
	@Column(name="COMMENT_CONTENT")
	String content;
	@Column(name="COMMENT_WRITER")
	String writer;
	@Column(name="COMMENT_REG_DATE")
	String regDate;
	@Column(name="BOARD_NO")
	int boardNo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
}
