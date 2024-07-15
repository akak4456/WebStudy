package com.adele.notice.model.dao;

import com.adele.notice.model.vo.Notice;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoticeDAO {
    public int insertNotice(SqlSession session, Notice notice) {
        int result = session.insert("NoticeMapper.insertNotice", notice);
        return result;
    }

    public List<Notice> selectList(SqlSession session) {
        List<Notice> list = session.selectList("NoticeMapper.selectList");
        return list;
    }

    public Notice selectOne(SqlSession session, int noticeNo) {
        Notice result = session.selectOne("NoticeMapper.selectOne", noticeNo);
        return result;
    }
}
