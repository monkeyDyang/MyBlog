package com.blog.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateSessionFactory {
	
	//引入sessionFactory工厂
	private static SessionFactory	sessionFactory;
	//构造Configuration配置
	private static Configuration	configuration	=	new Configuration();
	//定义一个threadlocal对象用于存放session
	private static ThreadLocal<Session> threadLocal =new ThreadLocal<>();
	
	//构建SessionFactory的静态块
	static {
		//读取放在classpath下的全局文件 .cgf.xml
		configuration.configure();
		//构造serviceRegistry对象（注册服务），通过classpath下的全局文件.cgf.xml的配置建立起注册服务
		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//生成一个sessionFactory
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	//获取session对象
	public static Session getSession() {
		Session session = threadLocal.get();
		if(null==session||session.isOpen()) {
			if(sessionFactory==null) {
				rebuildSessionFactory();
			}
		}
		//如果sessionFactory不为空，就打开session，然后将其赋给session
		session=(sessionFactory!=null)?sessionFactory.openSession():null;
		//将session设置到threadlocal中
		threadLocal.set(session);
		return session;
	}
	
	//重建sessionFactory
	private static void  rebuildSessionFactory() {
		configuration.configure();
		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	//关闭session、SessionFactory
	public static void close() {
		/**
		 * 将threadlocal的值赋给session然后将threadlocal的值设为空，如果session的值不为空则关闭session
		 */
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session!=null) {
			session.close();
		}
		sessionFactory.close();
	}
	
}
