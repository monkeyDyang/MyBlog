package com.blog.server.Impl;

import java.util.List;

import com.blog.bean.MsgBoard;
import com.blog.dao.MsgBoardDao;
import com.blog.dao.impl.MsgBoardDaoImpl;
import com.blog.server.MsgBoardService;

public class MsgBoardServiceImpl implements MsgBoardService {

	private MsgBoardDao dao = new MsgBoardDaoImpl();
	
	@Override
	public void addMsgBoard(MsgBoard msg) {
		dao.insertMsgBoard(msg);
	}

	@Override
	public List<MsgBoard> findMsgBoard(int page) {
		return dao.selsetMsgBoard(page);
	}

	@Override
	public void removeMsgBoard(MsgBoard msg) {
		dao.deleteMsgBoard(msg);
	}

}
