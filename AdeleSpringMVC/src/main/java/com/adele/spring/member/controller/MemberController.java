package com.adele.spring.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adele.spring.member.domain.MemberVO;
import com.adele.spring.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/register.kh", method=RequestMethod.GET)
	public String showInsertForm(Model model) {
		return "member/insert";
	}
	
	@RequestMapping(value="/member/mypage.kh", method=RequestMethod.GET)
	public String showMyPage(Model model, HttpSession session) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			MemberVO member = mService.selectOneById(memberId);
			if(member != null) {
				model.addAttribute("member", member);
				return "member/mypage";
			} else {
				model.addAttribute("msg","정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/update.kh", method=RequestMethod.GET)
	public String showUpdateForm(Model model, HttpSession session) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			MemberVO member = mService.selectOneById(memberId);
			if(member != null) {
				model.addAttribute("member", member);
				return "member/update";
			} else {
				model.addAttribute("msg","정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/update.kh", method=RequestMethod.POST)
	public String updateMember(Model model,
			@RequestParam("memberPw") String memberPw,
			@RequestParam(value = "memberAge", required=false, defaultValue="0") int memberAge,
			@RequestParam(value = "memberGender", required=false) String memberGender,
			@RequestParam(value = "memberEmail", required=false) String memberEmail,
			@RequestParam(value = "memberPhone", required=false) String memberPhone,
			@RequestParam(value = "memberAddress", required=false) String memberAddress,
			@RequestParam("memberId") String memberId) {
		try {
			MemberVO member = new MemberVO(memberId, memberPw, memberAge, memberGender,memberEmail, memberPhone, memberAddress);
			int result = mService.updateMember(member);
			if(result > 0) {
				return "redirect:/member/mypage.kh";
			} else {
				model.addAttribute("msg","정보수정이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/delete.kh", method=RequestMethod.GET)
	public String deleteMember(Model model, HttpSession session) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			int result = mService.deleteMember(memberId);
			if(result > 0) {
				return "redirect:/member/logout.kh";
			} else {
				model.addAttribute("msg", "회원탈퇴가 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch(Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
	public String insertMember(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPw") String memberPw,
			@RequestParam("memberName") String memberName,
			@RequestParam(value = "memberAge", required=false, defaultValue="0") int age,
			@RequestParam(value = "memberGender", required=false) String memberGender,
			@RequestParam(value="memberEmail", required=false) String memberEmail,
			@RequestParam(value="memberPhone", required=false) String memberPhone,
			@RequestParam(value="memberAddress", required=false) String memberAddress,
			Model model
	) {
		try {
			MemberVO member = new MemberVO(memberId, memberPw, memberName, age, memberGender, memberEmail, memberPhone, memberAddress);
			int result = mService.insertMember(member);
			if(result > 0) {
				// 메인페이지로 이동
				return "redirect:/index.jsp";
			} else {
				// 에러페이지로 이동
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// 에러페이지로 이동			
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
	public String checkLogin(Model model, HttpSession session,String memberId, String memberPw) {
		try {
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member = mService.checkMemberLogin(member);
			if(member != null) {
				// 로그인 성공 후 세션에 정보 저장
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				return "redirect:/";
			} else {
				// 로그인 실패
				return "common/errorPage";
			}
		} catch (Exception e) {			
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
	public String memberLogout(Model model, HttpSession session) {
		try {
			if(session != null) {
				session.invalidate();
				return "redirect:/";
			} else {
				model.addAttribute("msg", "로그아웃을 완료하지 못하엿습니다.");
				return "common/errorPage";
			}
		} catch(Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
