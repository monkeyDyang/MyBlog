package com.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blog.bean.MsgBoard;
import com.blog.dao.MsgBoardDao;
import com.blog.util.HibernateSessionFactory;

public class MsgBoardDaoImpl implements MsgBoardDao {

	private Session session = HibernateSessionFactory.getSession();
	private Transaction transaction = null;
	
	//开启事务
	public  void begin() {
		//开启事务
		transaction = session.beginTransaction();
	}
	//关闭事务
	public void close() {
		//关闭事务
		HibernateSessionFactory.close();
	}
	
	@Override
	public void insertMsgBoard(MsgBoard msgBoard) {
		// TODO Auto-generated method stub
		/**
		 * 增加一条留言
		 */
		//开启事务
		begin();
		//执行命令
		session.save(msgBoard);
		//提交事务
		transaction.commit();
		//关闭事务
		close();
	}

	@Override
	public List<MsgBoard> selsetMsgBoard(int page) {
		/**
		 * 查询留言板数据
		 * 分页查询、一次10条
		 * 返回查询结果
		 */
		int start = (page-1)*10;
		//开启事务
		begin();
		//执行命令
		 Query query = session.createQuery("from MsgBoard");
	    //设置分页位置
	    query.setFirstResult(start);
	    query.setMaxResults(10);
	    List<MsgBoard> list = query.list();
		//提交事务
		transaction.commit();
		//关闭事务
		close();
		return list;
	}

	@Override
	public void deleteMsgBoard(MsgBoard msgBoard) {
		/**
		 * 删除一条留言
		 */
		//开启事务
		begin();
		//执行命令
		/**
		 * 根据msgboard中的id来删除对应数据
		 */
		session.delete(msgBoard);
		//提交事务
		transaction.commit();
		//关闭事务
		close();
	}	
}
