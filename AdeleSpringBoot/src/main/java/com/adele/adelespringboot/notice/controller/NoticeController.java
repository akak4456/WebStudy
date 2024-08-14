package com.adele.adelespringboot.notice.controller;

import com.adele.adelespringboot.common.utility.Util;
import com.adele.adelespringboot.notice.model.vo.NoticeFile;
import com.adele.adelespringboot.notice.model.vo.Pagination;
import com.adele.adelespringboot.notice.service.NoticeService;
import com.adele.adelespringboot.notice.model.vo.Notice;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    private NoticeService nService;

    public NoticeController() {}

    @Autowired
    public NoticeController(NoticeService nService) {
        this.nService = nService;
    }

    @GetMapping("/detail/{noticeNo}")
    public String showNoticeDetail(@PathVariable("noticeNo") Integer noticeNo, Model model) {
        Notice notice = nService.selectOne(noticeNo);
        model.addAttribute("notice", notice);
        return "notice/noticeDetail";
    }

    @GetMapping("/list")
    public String showNoticeList(@RequestParam(value = "cp", required = false, defaultValue = "1") Integer currentPage, Model model) {
        int totalCount = nService.getTotalCount();
        Pagination pn = new Pagination(totalCount, currentPage);
        int limit = pn.getBoardLimit();
        int offset = (currentPage - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Notice> nList = nService.selectList(currentPage, rowBounds);
        model.addAttribute("nList", nList);
        model.addAttribute("pn", pn);
        return "notice/noticeList";
    }

    @GetMapping("/write")
    public String showWriteForm(HttpSession session) {
        session.setAttribute("memberId", "admin"); // 임시 부여 TODO 이 부분 수정해라...
        return "notice/noticeWrite";
    }

    @PostMapping("/write")
    public String noticeWrite(Notice inputNotice
            , @SessionAttribute("memberId") String memberId
    , @RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
        inputNotice.setNoticeWriter(memberId);
        int result = nService.insertNotice(inputNotice, uploadFile);
//        if(uploadFile != null) {
//            String fileName = uploadFile.getOriginalFilename();
//            String fileRename = Util.fileRename(fileName);
//
//            NoticeFile noticeFile = new NoticeFile();
//            noticeFile.setFileName(fileName);
//            noticeFile.setFileRename(fileRename);
//            noticeFile.setUploadFile(uploadFile);
//            result = nService.insertNoticeFile(noticeFile);
//        }
        return "redirect:/notice/list";
    }

    @GetMapping("/modify/{noticeNo}")
    public String showModifyForm(@PathVariable("noticeNo") Integer noticeNo, Model model) {
        Notice notice = nService.selectOne(noticeNo);
        model.addAttribute("notice", notice);
        return "notice/noticeModify";
    }
    @PostMapping("/modify")
    public String noticeModify(Notice notice, @RequestParam("reloadFile") MultipartFile reloadFile) throws IllegalStateException, IOException {
        int result = nService.updateNotice(notice, reloadFile);
        return "redirect:/notice/list";
    }

    @GetMapping("/delete/{noticeNo}")
    public String deleteNotice(@PathVariable("noticeNo") Integer noticeNo) {
        int result = nService.deleteNotice(noticeNo);
        return "redirect:/notice/list";
    }
}
