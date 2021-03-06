package edu.spring.studyware.register.persistance;

import java.util.List;

import edu.spring.studyware.domain.ApplyVO;
import edu.spring.studyware.domain.RecruitCateVO;
import edu.spring.studyware.domain.RecruitDTO;
import edu.spring.studyware.domain.RecruitTypeVO;
import edu.spring.studyware.domain.RecruitVO;

public interface StudyCreateDAO {

	// 1. 스터디 종류(IT, 외국어, 철학 등등) 리스트 찾기
	public abstract List<RecruitCateVO> recruitCateName();

	// 2. 모집 구분(신규/충원) 리스트 찾기
	public abstract List<RecruitTypeVO> recruitTypeName();

	// 3. 모집 구분 내용을 가지고 모집 구분 번호를 찾는다
	public abstract int recruitTypeNo(String recruitType);

	// 4. 스터디 종류 내용을 가지고 스터디 종류 번호를 찾는다
	public abstract int recruitCateNo(String studyCate);

	// 5. 스터디 등록(Insert)
	public abstract int insertRecruit(RecruitVO recruitVO);

	// 6. 메인화면 스터디 디테일 Test
	public abstract List<RecruitVO> recruitDetail();
	
	// 7. 진행중인 모집 리스트 찾기
	public abstract List<RecruitDTO> selectRecruitProgress(int member_no);
	
	// 8. 진행중인 신청 리스트 찾기
	public abstract List<ApplyVO> selectApplyProgress(int member_no);

}
