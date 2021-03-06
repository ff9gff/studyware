package edu.spring.studyware.member.persistance;

import java.util.List;

import edu.spring.studyware.domain.MemberDTO;
import edu.spring.studyware.domain.MemberNickDTO;
import edu.spring.studyware.domain.MemberVO;
import edu.spring.studyware.domain.Region2VO;
import edu.spring.studyware.domain.Region1VO;

public interface MemberDAO {

	// 1. 회원가입 양식에 들어갈 지역1 리스트
	public abstract List<Region1VO> memberRegionDepth1();

	// 2. depth1을 가지고 depth2를 찾는다.
	public abstract List<Region2VO> memberRegionDepth2(String region1);

	// 3. depth1 & depth2를 가지고 최종 지역 번호를 찾는다.
	public abstract int memberRegionNo(Region1VO region1vo);

	// 4. 모든 데이터를 가지고 회원 가입을 진행한다. DB Insert
	public abstract int memberSignUp(MemberVO memberVO);
	
	// 5. 모든 멤버 리스트를 조회한다
	public abstract List<MemberDTO> selectList();
	

	// 6. 세션id값으로 memberVO select
	public abstract MemberVO memberSelectOne(String userid);

	// 6. 회원 권한을 수정한다.
	public abstract int updateAuth(int member_no, int member_auth_no);
	
	// 7. 회원 닉네임 리스트를 조회한다
	public abstract List<MemberNickDTO> selectNicklist();

	// 8. 로그인 
	public abstract MemberVO login(MemberVO memberVO);
	
}
