package com.adele.notice.model.dao;

import com.adele.notice.model.vo.Notice;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoticeDAO {
    public int insertNotice(SqlSession session, Notice notice) {
        int result = session.insert("NoticeMapper.insertNotice", notice);
        return result;
    }

    public List<Notice> selectList(SqlSession session, int currentPage) {
        int limit = 10;
        int offset = (currentPage - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Notice> list = session.selectList("NoticeMapper.selectList", null, rowBounds);
        return list;
    }

    public Notice selectOne(SqlSession session, int noticeNo) {
        Notice result = session.selectOne("NoticeMapper.selectOne", noticeNo);
        return result;
    }

    public int updateNotice(SqlSession session, Notice notice) {
        int result = session.update("NoticeMapper.updateNotice", notice);
        return result;
    }

    public int deleteNotice(SqlSession session, int noticeNo) {
        int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
        return result;
    }

    public int getTotalCount(SqlSession session) {
        int totalCount = session.selectOne("NoticeMapper.getTotalCount");
        return totalCount;
    }
}
