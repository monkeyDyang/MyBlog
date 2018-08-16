package com.blog.action;

import java.util.List;

import com.blog.bean.MsgBoard;
import com.blog.server.MsgBoardService;
import com.blog.server.Impl.MsgBoardServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	/**
	 * Index起始页action
	 */
	private List<MsgBoard> mList = null;
	
	@Override
	public String execute() throws Exception {
		int page = 1;//页码
		//从数据库中读取十条数据
		MsgBoardService dao = new MsgBoardServiceImpl();
		mList = dao.findMsgBoard(page);
		return NONE;
	}
	
	public List<MsgBoard> getmList() {
		return mList;
	}
}
