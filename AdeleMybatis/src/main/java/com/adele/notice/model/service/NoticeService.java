package com.adele.notice.model.service;

import com.adele.common.SqlSessionTemplate;
import com.adele.notice.model.dao.NoticeDAO;
import com.adele.notice.model.vo.Notice;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoticeService {
    private SqlSession session;
    private NoticeDAO nDao;
    public NoticeService() {
        session = SqlSessionTemplate.getSqlSession();
        nDao = new NoticeDAO();
    }
    public int insertNotice(Notice notice) {
        int result = nDao.insertNotice(session, notice);
        return result;
    }

    public List<Notice> selectAllNotice() {
        List<Notice> nList = nDao.selectList(session);
        return nList;
    }

    public Notice selectOneByNo(int noticeNo) {
        Notice result = nDao.selectOne(session, noticeNo);
        return result;
    }
}
