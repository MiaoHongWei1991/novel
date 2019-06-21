package com.novel.cn.dao.mapper;

import com.novel.cn.service.homepage.result.HomeRecentUpdateResult;
import com.novel.cn.service.homepage.result.HomeZoneRecommendResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author dailong
* @Description  首页小说展示
* @date 2018/9/13 下午3:05
*/
public interface HomePageZoneMapper {

    /**
    * @author dailong
    * @Description 查询首页专区小说推荐
    * @date 2018/9/14 上午9:16
    */
    List<HomeZoneRecommendResult> findHomeZoneRecommendNovel(Integer labelId);

    /**
    * @author dailong
    * @Description 查询最近七天更新的小说
    * @date 2018/9/15 下午5:11
    */
    List<HomeRecentUpdateResult> findRecentUpdateNovel(@Param("startDate") String startDate,@Param("endDate") String endDate);

    /**
     * 统计首页专区推荐小说数量
     * @param novelId
     * @param labelId
     * @return
     */
    Integer countHomeZoneRecommendNovel(@Param("novelId") String novelId, @Param("labelId") String labelId);
}
