package com.blog.text;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;
import org.junit.Test;

import com.blog.bean.MsgBoard;
import com.blog.dao.impl.MsgBoardDaoImpl;
import com.blog.util.HibernateSessionFactory;

public class Demo {
	
	private static MsgBoardDaoImpl msgBoardDaoImpl = new MsgBoardDaoImpl();
	private static Date date = new Date();
	
	public static void main(String[] args) {
		MsgBoardDaoImpl msgBoardDaoImpl = new MsgBoardDaoImpl();
		List<MsgBoard> msgBoards = msgBoardDaoImpl.selsetMsgBoard(1);
		for(MsgBoard msgBoard:msgBoards) {
			System.out.println(msgBoard.getNo());
		}
	
	}
	
	public static void insert() {
		//添加一条记录
		MsgBoard msgBoard = new MsgBoard( 0, "name", date, "message");
		msgBoardDaoImpl.insertMsgBoard(msgBoard);
	}
}
