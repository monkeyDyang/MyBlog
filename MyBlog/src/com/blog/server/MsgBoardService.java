package com.blog.server;

import java.util.List;

import com.blog.bean.MsgBoard;

public interface MsgBoardService {
	public	void			addMsgBoard(MsgBoard msg);			//增
	public	List<MsgBoard>	findMsgBoard(int page);				//查
	public	void			removeMsgBoard(MsgBoard msg);		//删
}
