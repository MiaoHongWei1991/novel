package com.novel.cn.dao.mapper;

import com.novel.cn.service.novelchapter.order.ReadRecord;
import com.novel.cn.service.personalCenterService.result.MobileNookshelfResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 手机端我的书架
 *
 * @author: zhaolei
 * @date: 2018/12/29 15:12
 */
public interface MobileNookshelMapper {
    /**
     * 获取已经阅读的收藏小说
     * zhaolei 11:09 2018/4/20
     */
    List<MobileNookshelfResult> getAppReadCollection(@Param("readRecordList") List<ReadRecord> readRecordList, @Param("userId") Long userId);

    /***
     * 查询未读收藏小说
     * zhaolei 17:51 2018/4/26
     */
    List<MobileNookshelfResult> getAppUnreadCollection(@Param("novleIdList") List<String> novleIdList, @Param("user_id") Long user_id);

    /**
     * 查询小说浏览历史记录
     * zhaolei 16:46 2018/4/22
     */
    List<MobileNookshelfResult> getNovleHistory(@Param("userId") Long userId);

    /**
     * 查询阅读过的自动订阅小说
     * zhaolei 18:34 2018/4/27
     */
    List<MobileNookshelfResult> getMyBookByReadLst(@Param("readLst") List<ReadRecord> readList, @Param("user_id") Long userId);

    /**
     * 根据小说id查询小说自动订阅信息
     * zhaolei 21:23 2018/4/27
     */
    List<MobileNookshelfResult> getMyBookByNovelIds(@Param("novelIds") List<String> novelIdList, @Param("user_id") Long userId);


    void moveMyNovel(@Param("userId") String userId, @Param("novelMap") Map<String, Integer> novelmap);


}
