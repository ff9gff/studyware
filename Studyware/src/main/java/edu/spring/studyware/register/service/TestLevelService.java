package edu.spring.studyware.register.service;

import java.util.List;

import edu.spring.studyware.domain.LevelNameVO;
import edu.spring.studyware.domain.LevelVO;
import edu.spring.studyware.domain.LevelValueVO;

//공부수준 테스트용 Service입니다.
//테스트 후 삭제할 예정입니다.

import edu.spring.studyware.domain.LevelListVO;

public interface TestLevelService {
	
	// 1. 레벨 리스트(상,중,하) 가져오기
	public abstract List<LevelListVO> levelList();
	
	// 2. 공부내용 Insert
	public abstract int insertLevelName(LevelNameVO levelNameVO);
	
	// 3. 공부수준 Insert
	public abstract int insertLevelValue(LevelValueVO levelValueVO);
	
	// 4. 내용번호 & 수준번호 Insert
	public abstract int insertNameValueNO(LevelVO levelVO);

}
