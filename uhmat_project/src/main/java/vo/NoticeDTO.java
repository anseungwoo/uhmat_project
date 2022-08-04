package vo;

import java.sql.*;

/*
 	CREATE TABLE noticeBoard(
 		idx INT PRIMARY KEY,
 		name VARCHAR(20) NOT NULL,
 		passwd VARCHAR(16) NOT NULL,
 		subject VARCHAR(20) NOT NULL,
 		content VARCHAR(2000) NOT NULL,
 		date DATE NOT NULL,
 		real_file VARCHAR(100),
 		original_file VARCHAR(100)
 	);
 		
 */


public class NoticeDTO {
	private int idx;
	private String name;
	private String passwd;
	private String subject;
	private String content;
	private Date date;
	private String real_file;
	private String original_file;
	
	public final int getIdx() {
		return idx;
	}
	public final void setIdx(int idx) {
		this.idx = idx;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPasswd() {
		return passwd;
	}
	public final void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final Date getDate() {
		return date;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	public final String getReal_file() {
		return real_file;
	}
	public final void setReal_file(String real_file) {
		this.real_file = real_file;
	}
	public final String getOriginal_file() {
		return original_file;
	}
	public final void setOriginal_file(String original_file) {
		this.original_file = original_file;
	}
	
}
