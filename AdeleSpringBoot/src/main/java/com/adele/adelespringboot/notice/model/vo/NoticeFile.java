package com.adele.adelespringboot.notice.model.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NoticeFile {
    private Integer fileNo;
    private String fileName;
    private String fileRename;
    private String filePath;
    private Integer noticeNo;
}
