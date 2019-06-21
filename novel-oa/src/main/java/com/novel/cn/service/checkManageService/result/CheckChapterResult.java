package com.novel.cn.service.checkManageService.result;

import lombok.Data;

import java.util.Date;

/**
 * @author dailong
 * @ClassName: CheckChapterResult
 * @Description: TODO
 * @date 2018/10/11 下午4:36
 */
@Data
public class CheckChapterResult {
    private String novelId;
    private String chapterId;
    private Long chapter;
    private String chapterTitle;
    private Date createTime;
    private Date publishTime;
    private String volumeId;
    private Long volume;
    private String volumeTitle;
    private Integer status;
    private String novelTitle;
    private String penName;
    private Long chapterWords;

}
