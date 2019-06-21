package com.novel.cn.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TblNovelMessage {
    // 主键id
    private Long id;

    // 当前用户id
    private Integer userId;

    // 类型中文名称
    private String typeName;

    // 类型数字，方便前端跳转
    private Integer typeNumber;

    // 消息内容
    private String headContent;

    // 消息状态，1已读0未读
    private int messageStatus;

    // 消息创建时间
    private Date createTime;

    // 消息所属人角色（1普通用户2作者3编辑）
    private int messageType;

    // 时间字符串
    private String sortTime;
    // 小说id
    private String novelId;
    // 评论id
    private String commentId;
    // 章节id
    private String chapterId;
}