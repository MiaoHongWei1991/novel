package com.novel.cn.service.unioncenter.result;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dailong
 * @ClassName: UserUpayStatisResult
 * @Description: TODO
 * @date 2019/1/29 下午2:02
 */
@Data
public class UserUpayStatisResult {

    private String userId;
    private BigDecimal rechargeAmount;
    private String rechargeTime;
    private String novelId;
    private String novelTitle;
    private String chapterId;
    private String chapterTitle;
    private String userNickName;
    private int userGender;
    private String userGenderName;
    private String qqOpenId;
    private String wechatOpenId;
    private String sinawebOpenId;
}
