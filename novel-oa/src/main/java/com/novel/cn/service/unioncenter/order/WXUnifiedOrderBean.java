package com.novel.cn.service.unioncenter.order;

import lombok.Data;

/**
 * Created by le on 2017/11/29.
 */
@Data
public class WXUnifiedOrderBean {
    /*商品描述*/
    private String body;
    /*交易金额*/
    private String totalFee;
    /*订单号*/
    private String orderNum;

}
