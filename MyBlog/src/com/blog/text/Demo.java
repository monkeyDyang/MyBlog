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
import com.blog.server.MsgBoardService;
import com.blog.server.Impl.MsgBoardServiceImpl;
import com.blog.util.HibernateSessionFactory;

public class Demo {
	
	private static MsgBoardService dao = new MsgBoardServiceImpl();
	private static Date date = new Date();
	
	public static void main(String[] args) {
//		MsgBoardDaoImpl msgBoardDaoImpl = new MsgBoardDaoImpl();
//		List<MsgBoard> msgBoards = msgBoardDaoImpl.selsetMsgBoard(1);
//		for(MsgBoard msgBoard:msgBoards) {
//			System.out.println(msgBoard.getNo());
//		}
		
	 	List<MsgBoard> mList = dao.findMsgBoard(1);
	 	for(MsgBoard list:mList) {
	 		System.out.println(list.getNo());
	 	}
	}
}
