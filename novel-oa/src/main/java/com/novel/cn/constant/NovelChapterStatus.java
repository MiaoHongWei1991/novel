package com.novel.cn.constant;

/**
 * 小说章节状态
 * Created by LiZhong on 2018/10/8.
 */
public enum NovelChapterStatus {

    noPublished(0),     //暂存待发布
    reviewing(2),       //审核中
    reviewSuccess(3),   //审核通过
    reviewFail(4),      //审核不通过
    published(1);       //已发布

    private Integer status;

    NovelChapterStatus(Integer status) { this.status = status; }

    public Integer getStatus() {
        return this.status;
    }

}
