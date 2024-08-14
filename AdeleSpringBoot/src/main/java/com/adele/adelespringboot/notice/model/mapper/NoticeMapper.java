package com.adele.adelespringboot.notice.model.mapper;

import com.adele.adelespringboot.notice.model.vo.Notice;
import com.adele.adelespringboot.notice.model.vo.NoticeFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface NoticeMapper {
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
    List<Notice> selectList(Integer currentPage, RowBounds rowBounds);

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

    /**
     * 공지사항 파일 등록 Mapper
     * @param noticeFile 파일
     * @return int 결과
     */
    int insertNoticeFile(NoticeFile noticeFile);
}
