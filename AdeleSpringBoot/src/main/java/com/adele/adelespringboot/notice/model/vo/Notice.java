package com.adele.adelespringboot.notice.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Notice {
    private Integer noticeNo;
    private String noticeSubject;
    private String noticeContent;
    private String noticeWriter;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp noticeDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp updateDate;
    private Integer viewCount;

    private NoticeFile noticeFile;
}
