package com.novel.cn.dao.mapper;

import com.novel.cn.dao.entity.TblNovelSubscibeRecord;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 小说订阅消费dao
 * zhaolei 2018/8/218:16
 */
public interface TblNovelSubscibeRecordMapper {
    /**
     * 新增小说订阅消费
     * zhaolei 18:18 2018/8/2
     */
    int insertSubscibeRecord(TblNovelSubscibeRecord subscibeRecord);

    /**
     * 根据时间查询签约订阅小说消费记录
     * zhaolei 15:17 2018/8/8
     */
    List<TblNovelSubscibeRecord> querySignNovelSubscibeInfoByDate(@Param("date")Date date,@Param("lastDate") Date lastDate);

    /***
     * 查询小说月订阅充值阅读币数量
    * @author zhaolei
    * @date 2018/10/12 15:27
    * @pram [novelId, month]
    * @return java.math.BigDecimal
    */
    BigDecimal getMonthSubscibeCountMoneyCount(@Param("novelId") String novelId,@Param("month") Date month);
}
