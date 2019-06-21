package com.novel.cn.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 个人账户中心
 * Created by wuzhuan on 2018/4/17
 */
@Data
public class AccountCenter {
    private Long userId;                            // 用户uid
    private BigDecimal goldNumber;                  // 总阅读币数量
    private BigDecimal prendarGoldNumber;          //赠送阅读币数量
    private BigDecimal recargaGoldNumber;          //充值阅读币数量
    private Integer recommendNumber;              // 推荐票数
    private Integer diamondNumber;                // 钻石数量
    private Date diamondValidity;                 // 钻石有限期
    private Boolean isSubscibe;                   //是否订阅小说
    private Integer monthRecommendNumber;   //月票數量
    private String monthRecommendValidity;  //月票有效期限 yyyy-mm
}