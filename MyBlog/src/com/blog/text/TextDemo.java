package com.blog.text;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.sql.Insert;

import com.blog.bean.MsgBoard;
import com.blog.util.HibernateSessionFactory;

public class TextDemo {
	

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = null;
		//开启事务
		transaction = session.beginTransaction();
		//执行命令
		 Query query = session.createQuery("from MsgBoard");

	        //设置分页位置
	        query.setFirstResult(0);
	        query.setMaxResults(4);
	        List<MsgBoard> msgBoard = query.list();
	        System.out.println("***");
	        for(MsgBoard msgBoard2:msgBoard) {
	        	System.out.println(msgBoard2.getMessage());
	        }
	        System.out.println("***");
		//提交事务
		transaction.commit();
		//关闭事务
		
		HibernateSessionFactory.close();
		
		 

	}
	
	
}
