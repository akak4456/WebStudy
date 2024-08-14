package com.adele.adelespringboot.notice.model.dao;

import com.adele.adelespringboot.notice.model.vo.Notice;

import java.util.List;

public interface NoticeDAO {

    /**
     * 공지사항 상세조회 DAO
     * @param noticeNo 공지사항 번호
     * @return Notice notice
     */
    Notice selectOne(Integer noticeNo);

    /**
     * 공지사항 목록조회 DAO
     * @return List&lt;Notice&gt;
     */
    List<Notice> selectList(Integer currentPage);

    /**
     * 공지사항 등록 DAO
     * @param inputNotice input
     * @return int 결과
     */
    int insertNotice(Notice inputNotice);

    /**
     * 전체 게시물 갯수 DAO
     * @return int 게시물 갯수
     */
    int getTotalCount();

    /**
     * 공지사항 수정 DAO
     * @param notice 수정할 공지
     * @return int result
     */
    int updateNotice(Notice notice);

    /**
     * 공지사항 삭제 DAO
     * @param noticeNo 삭제할 공지사항 번호
     * @return int 결과
     */
    int deleteNotice(Integer noticeNo);
}
