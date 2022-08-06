package vo;

import java.sql.*;

/*
 	CREATE TABLE NoticeBoard(
 		idx INT PRIMARY KEY,
 		name VARCHAR(20) NOT NULL,
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
	private String subject;
	private String content;
	private Date date;
	private String real_File;
	private String original_File;
	
	public final String getReal_File() {
		return real_File;
	}
	public final void setReal_File(String real_File) {
		this.real_File = real_File;
	}
	public final String getOriginal_File() {
		return original_File;
	}
	public final void setOriginal_File(String original_File) {
		this.original_File = original_File;
	}
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
	
}
