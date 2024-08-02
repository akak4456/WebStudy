package com.adele.spring.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adele.spring.notice.domain.NoticeVO;
import com.adele.spring.notice.service.NoticeService;
import com.adele.spring.reply.domain.ReplyVO;
import com.adele.spring.reply.service.ReplyService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	@Autowired
	private ReplyService rService;

	@RequestMapping(value = "/notice/detail", method = RequestMethod.GET)
	public String showNoticeDetail(Model model, @RequestParam("noticeNo") int noticeNo) {
		try {
			NoticeVO notice = nService.selectOneByNo(noticeNo);
			if (notice != null) {
				List<ReplyVO> replyList = rService.selectReplyList(noticeNo);
				model.addAttribute("rList", replyList);
				model.addAttribute("notice", notice);
				return "notice/detail";
			} else {
				model.addAttribute("msg", "정보 조회에 실패했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/list.kh", method = RequestMethod.GET)
	public String showNoticeList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		try {
			int totalCount = nService.getTotalCount();
			int recordCountPerPage = 10;
			int naviTotalCount = 0;
			if (totalCount % recordCountPerPage != 0) {
				naviTotalCount = totalCount / recordCountPerPage + 1;
			} else {
				naviTotalCount = totalCount / recordCountPerPage;
			}
			int naviPageCount = 10;
			int startNavi = ((currentPage - 1) / naviPageCount) * naviPageCount + 1;
			int endNavi = startNavi + naviPageCount - 1;
			if (endNavi > naviTotalCount) {
				endNavi = naviTotalCount;
			}
			List<NoticeVO> nList = nService.selectNoticeList(currentPage);
			if (nList.size() > 0) {
				model.addAttribute("startNavi", startNavi);
				model.addAttribute("endNavi", endNavi);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("naviTotalCount", naviTotalCount);
				model.addAttribute("nList", nList);
				return "notice/list";
			} else {
				model.addAttribute("msg", "정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/search.kh", method = RequestMethod.POST)
	public String showSearchNotice(Model model, @RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchKeyword") String searchKeyword) {
		// VO 대신 Map을 쓸 수 있음.
		try {
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			List<NoticeVO> searchList = nService.searchNoticesByKeyword(paramMap);
			model.addAttribute("searchCondition", searchCondition);
			model.addAttribute("searchKeyword", searchKeyword);
			model.addAttribute("sList", searchList);
			return "notice/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/register.kh", method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "notice/register";
	}

	@RequestMapping(value = "/notice/register.kh", method = RequestMethod.POST)
	public String noticeRegister(Model model, HttpSession session, @RequestParam("noticeSubject") String noticeSubject,
			@RequestParam("noticeContent") String noticeContent) {
		try {
			String noticeWriter = (String) session.getAttribute("memberId");
			NoticeVO notice = new NoticeVO(noticeSubject, noticeContent, noticeWriter);
			int result = nService.insertNotice(notice);
			if (result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/update.kh", method = RequestMethod.POST)
	public String updateNotice(Model model, @ModelAttribute NoticeVO notice) {
		try {
			int result = nService.updateNotice(notice);
			if (result > 0) {
				return "redirect:/notice/detail.kh?noticeNo=" + notice.getNoticeNo();
			} else {
				model.addAttribute("msg", "수정이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/update.kh", method = RequestMethod.GET)
	public String showUpdateForm(Model model, @RequestParam("noticeNo") Integer noticeNo) {
		try {
			// Integer 여도 int로 오토언박싱되어 들어감.
			NoticeVO notice = nService.selectOneByNo(noticeNo);
			if (notice != null) {
				model.addAttribute("notice", notice);
				return "notice/update";
			} else {
				model.addAttribute("msg", "존재하지 않는 정보입니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/delete.kh", method = RequestMethod.GET)
	public String deleteNotice(Model model, @RequestParam("noticeNo") Integer noticeNo) {
		try {
			int result = nService.deleteNotice(noticeNo);
			if (result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 삭제가 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
