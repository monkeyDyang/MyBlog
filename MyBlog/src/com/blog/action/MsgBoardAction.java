package com.blog.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.blog.bean.MsgBoard;
import com.blog.server.MsgBoardService;
import com.blog.server.Impl.MsgBoardServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MsgBoardAction extends ActionSupport implements ModelDriven<MsgBoard>{
	
	private MsgBoard msgBoard;
	private MsgBoardService dao = new MsgBoardServiceImpl();
	private List<MsgBoard> mList = null;
	/**
	 * 新增一条留言
	 */
	public String addAction() {
		//存入数据库
		dao.addMsgBoard(getModel());
		return "add";
	}

	//获取表单数据存储到 msgBoard
	@Override
	public MsgBoard getModel() {
		if(msgBoard == null)
		{
			return msgBoard = new MsgBoard();
		}
		Date date = new Date();
		msgBoard.setDate(date);
		return msgBoard;
	}
	
	/**
	 * 查询留言
	 */
	public String findAction() {
		int page = 1;//页码
		//从数据库中读取十条数据
		mList = dao.findMsgBoard(page);
		
		// 获取广义值栈
		ActionContext ac = ActionContext.getContext();
		// 通过广义值栈获取Session域
		Map<String, Object> session = ac.getSession();
		session.put("msgs", mList);
		
		return SUCCESS;
	}

	public List<MsgBoard> getmList() {
		return mList;
	}
}
