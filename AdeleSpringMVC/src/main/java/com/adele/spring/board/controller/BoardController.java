package com.adele.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adele.spring.board.domain.BoardVO;
import com.adele.spring.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bService;
	
	@RequestMapping(value="/register.kh", method=RequestMethod.GET)
	public String showBoardRegister(Model model) {
		return "board/register";
	}
	
	@RequestMapping(value="/register.kh", method=RequestMethod.POST)
	public String registerOneBoard(Model model, 
			HttpSession session, 
			RedirectAttributes rattr,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request,
			@ModelAttribute BoardVO board) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			Map<String, Object> fileInfo = saveFile(uploadFile, session);
			String fileName = (String) fileInfo.get("fileName");
			String fileRename = (String) fileInfo.get("fileRename");
			String filePath = (String) fileInfo.get("filePath");
			long fileLength = (long) fileInfo.get("fileSize");
			board.setBoardFilename(fileName);
			board.setBoardFileRename(fileRename);
			board.setBoardFilepath(filePath);
			board.setBoardFilelength(fileLength);
			memberId = memberId != null ? memberId : "anonymous";
			board.setBoardWriter(memberId);
			int result = bService.insertBoard(board);
			if(result > 0) {
				rattr.addFlashAttribute("message", "게시글이 성공적으로 등록되었습니다.");
			} else {
				rattr.addFlashAttribute("message", "게시글이 등록이 완료되지 않았습니다.");
			}
			return "redirect:/board/list.kh";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	private Map<String, Object> saveFile(MultipartFile uploadFile, HttpSession session) throws IllegalStateException, IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String fileName = uploadFile.getOriginalFilename();
		Long fileSize= uploadFile.getSize();
		
		String savePath = "/resources/bUploadFiles";
		String filePath = session.getServletContext().getRealPath(savePath);
		// A: 1.png, B: 1.png
		// 올린 시각을 기준으로 파일 이름을 만들어서 따로 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String resultStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		String fileRename = resultStr + "." + ext;
		
		String saveFile = filePath + "\\" + fileRename;
		
		File file = new File(saveFile);
		uploadFile.transferTo(file);
		
		result.put("fileName", fileName);
		result.put("fileRename", fileRename);
		result.put("filePath", filePath);
		result.put("fileSize", fileSize);
		return result;
	}

	@RequestMapping(value="/list.kh", method=RequestMethod.GET)
	public String showBoardList(Model model, @RequestParam(value="currentPage", defaultValue="1") Integer currentPage) {
	
		List<BoardVO> bList = bService.selectBoardList(currentPage);
		int totalCount = bService.getTotalCount(null);
		int recordCountPerPage = 10;
		int naviTotalCount = 0;
		if(totalCount % recordCountPerPage != 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = (startNavi - 1) + naviCountPerPage;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		model.addAttribute("startNavi", startNavi);
		model.addAttribute("endNavi", endNavi);
		model.addAttribute("naviTotalCount", naviTotalCount);
		model.addAttribute("bList", bList);
		model.addAttribute("currentPage", currentPage);
		return "board/list";
	}
	
	@RequestMapping(value="/detail.kh", method=RequestMethod.GET)
	public String showBoardDetail(Model model, Integer boardNo, Integer currentPage) {
		BoardVO board = bService.selectOneByNo(boardNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping(value="/delete.kh", method=RequestMethod.GET)
	public String deleteBoard(Model model, RedirectAttributes rattr, Integer boardNo) {
		int result = bService.deleteBoard(boardNo);
		if(result > 0) {
			rattr.addFlashAttribute("message", "게시물이 성공적으로 삭제되었습니다.");
		} else {
			rattr.addFlashAttribute("message", "게시물 삭제가 완료되지 않았습니다.");
		}
		return "redirect:/board/list.kh";
	}
	
	@RequestMapping(value="/update.kh", method=RequestMethod.GET)
	public String showUpdateForm(Model model, Integer boardNo) {
		BoardVO board = bService.selectOneByNo(boardNo);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	@RequestMapping(value="/update.kh", method= RequestMethod.POST)
	public String updateBoard(
			Model model, 
			HttpSession session,
			@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile,
			@ModelAttribute BoardVO board) throws IllegalStateException, IOException {
		Map<String, Object> infoMap = saveFile(reloadFile, session);
		String fileName = (String)infoMap.get("fileName");
		String fileRename = (String)infoMap.get("fileRename");
		String filePath = (String)infoMap.get("filePath");
		Long fileLength = (Long)infoMap.get("fileSize");
		board.setBoardFilename(fileName);
		board.setBoardFileRename(fileRename);
		board.setBoardFilepath(filePath);
		board.setBoardFilelength(fileLength);
		int result = bService.updateBoard(board);
		return "redirect:/board/detail.kh?boardNo=" + board.getBoardNo();
	}
	
	@RequestMapping(value="/search.kh", method= {RequestMethod.GET, RequestMethod.POST})
	public String showSearchList(Model model, @RequestParam Map<String, String> searchMap, @RequestParam(value="page", defaultValue="1") Integer currentPage) {
		int totalCount = bService.getTotalCount(searchMap);
		int naviTotalCount = 0;
		int recordCountPerPage = 10;
		if(totalCount % recordCountPerPage != 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = (startNavi - 1) + naviCountPerPage;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		List<BoardVO> searchList = bService.selectSearchList(searchMap, currentPage);
		model.addAttribute("startNavi", startNavi);
		model.addAttribute("endNavi", endNavi);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("naviTotalCount",naviTotalCount);
		model.addAttribute("searchCondition", searchMap.get("searchCondition"));
		model.addAttribute("searchKeyword", searchMap.get("searchKeyword"));
		model.addAttribute("sList", searchList);
		return "board/search";
	}
}
