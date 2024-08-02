package com.adele.spring.reply.domain;

import java.sql.Timestamp;

public class ReplyVO {
	private int replyNo;
	private int refNoticeNo;
	private String replyContent;
	private String replyWriter;
	private Timestamp rCreateDate;
	private Timestamp rUpdateDate;
	private String rStatus;
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefNoticeNo() {
		return refNoticeNo;
	}
	public void setRefNoticeNo(int refNoticeNo) {
		this.refNoticeNo = refNoticeNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Timestamp getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Timestamp rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Timestamp getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Timestamp rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	
	
	
}
