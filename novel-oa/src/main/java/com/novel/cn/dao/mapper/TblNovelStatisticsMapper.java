package com.novel.cn.dao.mapper;

import com.novel.cn.dao.entity.TblNovelStatisticsModel;
import org.springframework.stereotype.Repository;

/**
 * 作品数据统计接口
 * @author: zhaolei
 * @date: 2019/1/25 10:06
 */
@Repository
public interface TblNovelStatisticsMapper {
    /**
     * 新增小说统计信息
     * @return
     */
    void insertNovelStatistics(TblNovelStatisticsModel tblNovelStatisticsModel);

    /**
     * 修改小说统计信息
     * @param tblNovelStatisticsModel
     */
    void upadteNovelStatistics(TblNovelStatisticsModel tblNovelStatisticsModel);

}
