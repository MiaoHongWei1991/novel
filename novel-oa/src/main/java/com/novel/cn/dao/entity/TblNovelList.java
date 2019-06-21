package com.novel.cn.dao.entity;

import com.novel.cn.utils.ToString;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author：zhaochun
 * @CreatTime： 2018/4/17 21:44
 * 榜单
 */
@Data
public class TblNovelList  extends  TblNovel implements Serializable{
    private static final long serialVersionUID = -5128442124029172569L;

    // change 20180916
    private String type;
    private int limitSize; // 条数
    private int pageSize;   //每页条数
    private String resultType; //请求客户端app

    private String novelId;
    /**
     * 钻石
     */
    private Long diamond;
    /**
     * 推荐票
     */
    private Long recommendTicket;
    /**
     * 点击量
     */
    private Long click;
    /**
     * 订阅量
     */
    private Long subscibe;
    /**
     * 收藏量
     */
    private Long collection;
    /**
     * 月票数
     */
    private Long monthRecommendTicket;
    /**
     * 是否为新书（0 ：不是新书 1：是新书）'
     */
    private Byte isNewNovel;
    /**
     * 打赏的阅读币
     */
    private BigDecimal rewardsMoney;
    /**
     * 订阅的阅读币
     */
    private BigDecimal subscibeMoney;
    /**
     * 榜单类型 0 日 1 周 2 月 3 total
     */
    private Integer novelListType;
    /**
     * 新书 开始时间
     */
    private Date beginTime;
    /**
     * 新书 结束时间
     */
    private Date endTime;

    private String userId;

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
