package com.adele.notice.model.vo;

import java.sql.Date;

public class Notice {
    private long noticeNo;
    private String noticeSubject;
    private String noticeContent;
    private String noticeWriter;
    private Date regDate;
    private Date updateDate;
    private long viewCount;

    public Notice() {

    }

    public Notice(String noticeSubject, String noticeContent, String noticeWriter) {
        this.noticeSubject = noticeSubject;
        this.noticeContent = noticeContent;
        this.noticeWriter = noticeWriter;
    }

    public long getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(long noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeSubject() {
        return noticeSubject;
    }

    public void setNoticeSubject(String noticeSubject) {
        this.noticeSubject = noticeSubject;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeWriter() {
        return noticeWriter;
    }

    public void setNoticeWriter(String noticeWriter) {
        this.noticeWriter = noticeWriter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeNo=" + noticeNo +
                ", noticeSubject='" + noticeSubject + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeWriter='" + noticeWriter + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                ", viewCount=" + viewCount +
                '}';
    }
}
