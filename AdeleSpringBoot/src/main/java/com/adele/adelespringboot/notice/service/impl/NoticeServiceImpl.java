package com.adele.adelespringboot.notice.service.impl;

import com.adele.adelespringboot.common.utility.Util;
import com.adele.adelespringboot.notice.model.dao.NoticeDAO;
import com.adele.adelespringboot.notice.model.mapper.NoticeMapper;
import com.adele.adelespringboot.notice.model.vo.Notice;
import com.adele.adelespringboot.notice.model.vo.NoticeFile;
import com.adele.adelespringboot.notice.service.NoticeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    // private NoticeDAO nDao;
    private NoticeMapper mapper;
    public NoticeServiceImpl() {}
//    @Autowired
//    public NoticeServiceImpl(NoticeDAO nDao) {
//        this.nDao = nDao;
//    }
    @Autowired
    public NoticeServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public Notice selectOne(Integer noticeNo) {
        Notice notice = mapper.selectOne(noticeNo);
        return notice;
    }

    @Override
    public List<Notice> selectList(Integer currentPage, RowBounds rowBounds) {
        List<Notice> nList = mapper.selectList(currentPage, rowBounds);
        return nList;
    }

    @Override
    public int insertNotice(Notice inputNotice, MultipartFile uploadFile) throws IllegalStateException, IOException {
        int result = mapper.insertNotice(inputNotice);
        if(uploadFile != null) {
            String fileName = uploadFile.getOriginalFilename();
            String fileRename = Util.fileRename(fileName);

            String filePath = "/images/notice/";

            uploadFile.transferTo(new File("C:/uploadFile/notice/" + fileRename));

            NoticeFile noticeFile = new NoticeFile();
            noticeFile.setFileName(fileName);
            noticeFile.setFileRename(fileRename);
            noticeFile.setFilePath(filePath);
            noticeFile.setNoticeNo(inputNotice.getNoticeNo());
            result = mapper.insertNoticeFile(noticeFile);
        }
        return result;
    }

    @Override
    public int getTotalCount() {
        int totalCount = mapper.getTotalCount();
        return totalCount;
    }

    @Override
    public int updateNotice(Notice notice) {
        int result = mapper.updateNotice(notice);
        return result;
    }

    @Override
    public int deleteNotice(Integer noticeNo) {
        int result = mapper.deleteNotice(noticeNo);
        return result;
    }

//    @Override
//    public int insertNoticeFile(NoticeFile noticeFile) throws IllegalStateException, IOException {
//        MultipartFile uploadFile = noticeFile.getUploadFile();
//        uploadFile.transferTo(new File("C:/uploadFile/notice"));
//        int result = mapper.insertNoticeFile(noticeFile);
//        return result;
//    }
}
