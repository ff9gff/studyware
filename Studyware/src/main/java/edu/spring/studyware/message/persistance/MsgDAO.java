package edu.spring.studyware.message.persistance;

import java.util.List;

import edu.spring.studyware.domain.msgVO;

public interface MsgDAO {

	public abstract int insert(msgVO vo);
	public abstract List<msgVO> select(int member_no);
	public abstract int update(int msg_no);
	public abstract int delete(int msg_no);
	
}// end interface
