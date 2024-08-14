package com.adele.adelespringboot.notice.service;

import com.adele.adelespringboot.notice.model.vo.Notice;
import com.adele.adelespringboot.notice.model.vo.NoticeFile;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoticeService {
    /**
     * 공지사항 상세조회 Service
     * @param noticeNo 공지사항 번호
     * @return Notice 공지사항
     */
    Notice selectOne(Integer noticeNo);

    /**
     * 공지사항 목록조회 Service
     * @return List&lt;Notice&gt; notice list
     */
    List<Notice> selectList(Integer currentPage, RowBounds rowBounds);

    /**
     * 공지사항 등록 Service
     * @param inputNotice 등록할 것
     * @return int 결과
     */
    int insertNotice(Notice inputNotice, MultipartFile uploadFile) throws IllegalStateException, IOException;

    /**
     * 전체 게시물 갯수 Service
     * @return int 게시물 갯수
     */
    int getTotalCount();

    /**
     * 공지사항 수정 Service
     * @param notice 수정할 공지
     * @return int 결과
     */
    int updateNotice(Notice notice);

    /**
     * 공지사항 삭제 Service
     * @param noticeNo 삭제할 공지사항 번호
     * @return int result
     */
    int deleteNotice(Integer noticeNo);

    /**
     * 공지사항 파일 등록 Service
     * @param noticeFile 파일
     * @return int 결과
     */
    // int insertNoticeFile(NoticeFile noticeFile) throws IllegalStateException, IOException;
}
