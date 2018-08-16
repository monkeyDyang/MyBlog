package com.blog.action;

import java.util.Date;

import com.blog.bean.MsgBoard;
import com.blog.server.MsgBoardService;
import com.blog.server.Impl.MsgBoardServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MsgBoardAction extends ActionSupport implements ModelDriven<MsgBoard>{
	
	private MsgBoard msgBoard;
	
	public String execute() {
		//存入数据库
		MsgBoardService dao = new MsgBoardServiceImpl();
		dao.addMsgBoard(getModel());
		return SUCCESS;
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
}
