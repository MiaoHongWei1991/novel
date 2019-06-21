package com.novel.cn.service.checkManageService.result;

import lombok.Data;

import java.util.Date;

/**
 * @author dailong
 * @ClassName: NewChapter
 * @Description: TODO
 * @date 2018/11/7 下午3:03
 */
@Data
public class NewChapter {

    private String novelId;         //小说id
    private String volumeId;        //卷id
    private Long volume;         //卷序号
    private String chapterId;       //章节id
    private Long chapter;       //章节序号
    private String chapterTitle;    //章节名
    private Date createTime;      //创建时间
}
