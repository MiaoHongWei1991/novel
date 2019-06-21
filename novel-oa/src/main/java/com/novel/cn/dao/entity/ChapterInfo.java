package com.novel.cn.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 小说章节信息
 * Created by lizhong on 2018/4/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterInfo {
    private String id;              //主键
    private Integer chapter;        //章序号
    private String title;           //章主题
    private String baseUrl;         //文件存储基础路径
    private String url;             //章节内容存储地址
    private Integer isFree;         //是否免费
    private BigDecimal money;       //章节所需虚拟币
    private String updateTime;      //修改时间
    private String createTime;      //创建时间
    private Integer words;          //章节字数
    private String volumeId;        //对应卷id
    private String novelId;         //小说id
    private Integer status;         //章节状态
    private String uploadType;      //文件上传方式
    private Integer updateNum;      //修改次数
    private String chapterLevel;    //章节等级
    private String describe;        //章节附加语
    private String publishTime;     //发布时间
    private Integer extChapterId;   //外部调用id

    /*********************非数据库字段，显示用*******************/
    private String content;         //章节内容
    private String updateStatus;    //能否修改
    private String isSubscribed;    //是否已订阅
    private List<String> paragraphs;    //段落
    private Boolean isLocked;       //是否加锁
}
