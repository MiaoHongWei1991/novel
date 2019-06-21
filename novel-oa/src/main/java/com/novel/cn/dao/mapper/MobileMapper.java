package com.novel.cn.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by LiZhong on 2018/12/5.
 */
public interface MobileMapper {

    List<Map<String, String>> getVolumes(@Param("novelId") String novelId);

    List<Map<String, String>> getChapters(@Param("novelId") String novelId, @Param("volume") String volume,
                                          @Param("userId") String userId, @Param("sort") String sort);

    List<Map<String, String>> getHeadRecommend(@Param("imgServerUrl") String imgServerUrl);
    List<Map<String, String>> getHotRecommend(@Param("limitNum") Integer limitNum);
    List<Map<String, String>> getEditorRecommend(@Param("imgServerUrl") String imgServerUrl);
    List<Map<String, String>> getHomepageRecommend(@Param("imgServerUrl") String imgServerUrl, @Param("type") String type);
    List<Map<String, String>> getRecentUpdate(@Param("startDate") String startDate, @Param("endDate") String endDate);
    Map<String, Object> getNovelInfo(@Param("imgServerUrl") String imgServerUrl, @Param("novelId") String novelId, @Param("userId") String userId);
    Map<String, String> getNovelNewChapter(@Param("novelId") String novelId);
    List<Map<String, Object>> getBoostRecommendRank();
    List<Map<String, Object>> getBoostDiamondRank();
    List<Map<String, Object>> getBoostMonthRecommendRank();
    Map<String, Object> getBoostMoneyRank(@Param("novelId") String novelId, @Param("startDate") Date startDate, @Param("endDate") Date endDate,
                                          @Param("todayDate") Date todayDate);
    List<Map<String, String>> getFansRewardInfo(@Param("novelId") String novelId);
    Map<String, String> personCenter(@Param("userId") String userId);
    Map<String, Object> getFirstVolumeChapter(@Param("novelId") String novelId);
}
