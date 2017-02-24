package edu.spring.studyware.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.studyware.domain.RecruitCateVO;
import edu.spring.studyware.domain.RecruitTypeVO;
import edu.spring.studyware.domain.Region1VO;
import edu.spring.studyware.member.service.MemberService;
import edu.spring.studyware.register.service.StudyCreateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private StudyCreateService studyCreateService;
	
	@Autowired
	private MemberService memberService;
	
	// 1. 스터디 등록 페이지로 이동
	@RequestMapping(value = "studyCreate/register", method = RequestMethod.GET)
	public String studyRegister(Locale locale, Model model) {
		
		List<RecruitTypeVO> recruitTypeList = studyCreateService.recruitTypeName();
		List<RecruitCateVO> recruitCateList = studyCreateService.recruitCateName();
		List<Region1VO> depth1List = memberService.memberRegionDepth1();
		
		for (int i = 0; i < recruitCateList.size(); i++) {
			System.out.println(recruitCateList.get(i).getName_recruit_cate());
		}
		
		logger.info("스터디등록");
		
		model.addAttribute("recruitTypeList", recruitTypeList);
		model.addAttribute("recruitCateList", recruitCateList);
		model.addAttribute("depth1List", depth1List);

		return "studyCreate/register_wr";

	}

	///////////////////////////////////////////////////////////////////////////////////

	// 2. 스터디종류 내용을 이용해서 스터디종류 번호를 찾는다
	@RequestMapping(value = "/studyCreate/studyCate", method = RequestMethod.POST)
	public void studyCate(Model model, @RequestBody String recruit_cate_name,
			HttpServletResponse response) throws IOException {
		logger.info("스터디종류 메소드 호출");
		logger.info("스터디종류 : " + recruit_cate_name);

		int recruit_cate_no = studyCreateService.recruitCateNo(recruit_cate_name);

		PrintWriter out = response.getWriter();

		if (recruit_cate_no > 0) {
			out.print(recruit_cate_no);
		}

		logger.info("스터디종류 번호: " + recruit_cate_no);

	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	// 3. 모집구분 내용을 이용해서 모집구분 번호를 찾는다
	@RequestMapping(value = "/studyCreate/studyType", method = RequestMethod.POST)
	public void studyType(Model model, @RequestBody String recruit_type_name,
			HttpServletResponse response) throws IOException {
		logger.info("모집 구분 메소드 호출");
		logger.info("모집구분 : " + recruit_type_name);

		int recruit_type_no = studyCreateService.recruitTypeNo(recruit_type_name);

		PrintWriter out = response.getWriter();

		if (recruit_type_no > 0) {
			out.print(recruit_type_no);
		}

		logger.info("모집 구분번호: " + recruit_type_no);

	}
}
