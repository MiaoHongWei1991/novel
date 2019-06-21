package com.novel.cn.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: YangYunHang
 * @Description:
 * @Date: 2018/4/26 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TblNovelScoreRecord implements Serializable {

	private static final long serialVersionUID = -1829557920297202117L;
	/*主键*/
	private Long id;
	/*小说ID*/
	private String novelId;
	/*用户ID*/
	private String userId;
	/*用户评分*/
	private BigDecimal score;
	/*创建日期*/
	private Date createDate;
}
