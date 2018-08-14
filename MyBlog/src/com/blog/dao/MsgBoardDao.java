package com.blog.dao;

import java.util.List;

import com.blog.bean.MsgBoard;

public interface MsgBoardDao {
	public	void	insertMsgBoard(MsgBoard msg);			//增
	public	List<MsgBoard>	selsetMsgBoard(int page);		//查
	public	void	deleteMsgBoard(MsgBoard msg);			//删

}