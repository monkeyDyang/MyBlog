package com.blog.bean;

import java.util.Date;

/**
 * 
 *  实体类——MsgBoard
 *  对应数据库表——msgboard
 */

public class MsgBoard {
	private	int No;
	private	String	Name;
	private	Date	Date;
	private	String	Message;
	
	public MsgBoard() {
		//无参构造函数
	}
	
	public MsgBoard(int no, String name,Date  date, String message) {
		super();
		No = no;
		Name = name;
		Date = date;
		Message = message;
	}
	
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDate() {
		return Date;
	}
	
	public void setDate(Date date) {
		Date = date;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
}
