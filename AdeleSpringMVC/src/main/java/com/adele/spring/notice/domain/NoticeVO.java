package com.adele.spring.notice.domain;

import java.sql.Timestamp;

public class NoticeVO {
	private Long 		noticeNo;
	private String 		noticeSubject;
	private String 		noticeContent;
	private String 		noticeWriter;
	private Timestamp 	noticeDate;
	private Timestamp 	updateDate;
	private Long 		viewCount;
	
	public NoticeVO(String noticeSubject, String noticeContent, String noticeWriter) {
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
	}

	public Long getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(Long noticeNo) {
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

	public Timestamp getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", noticeContent="
				+ noticeContent + ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", updateDate="
				+ updateDate + ", viewCount=" + viewCount + "]";
	}
	
	
}
