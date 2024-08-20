package com.adele.adelespringboot.notice.controller;

import com.adele.adelespringboot.notice.model.vo.Notice;
import com.adele.adelespringboot.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class RestNoticeController {
    private NoticeService nService;

    public RestNoticeController() {}

    @Autowired
    public RestNoticeController(NoticeService nService) {
        this.nService = nService;
    }
    @GetMapping("/detail2/{noticeNo}")
    public Notice showNoticeDetail(@PathVariable("noticeNo") Integer noticeNo, Model model) {
        Notice notice = nService.selectOne(noticeNo);
        model.addAttribute("notice", notice);
        return notice;
    }
}
