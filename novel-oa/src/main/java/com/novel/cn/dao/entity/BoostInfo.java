package com.novel.cn.dao.entity;

import com.novel.cn.dao.entity.base.BasePageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 捧场实体类
 * zhaolei 10:57 2018/7/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoostInfo extends BasePageEntity{
	private String id;						//捧场记录id
	private Long boostUserId;				//捧场用户id
	private String novelId;					//小说id
	private String boostType;				//捧场类型（打赏，推荐票，钻石）
	private Integer recommendTicket;		//推荐票数量
	private BigDecimal money;				//充值阅读币打赏数量
	private BigDecimal systemMoney;			//赠送类型阅读币打赏数量
	private Integer diamond;				//钻石数量
	private Date boostTime;					//捧场时间
	private Integer monthRecommend;			//月票

	//页面返回数据
	private Integer rank;					//排名
	private Integer difference;					//据前一名相差多少
	private Integer todayPeopleNumber;		//今日人数
	private Integer weekPeopleNumber;		//周人数
	private String userNickName;			//用户昵称
	private String novelTitle;				//小说名称
	private BigDecimal moneyCount;			//总打赏阅读币数量
	private String signType;				//签约类型

	//查询条件
	private Date startDate;					//查询条件开始时间
	private Date endDate;					//查询条件结束时间
	private String sessionId;				//sessionId

}
