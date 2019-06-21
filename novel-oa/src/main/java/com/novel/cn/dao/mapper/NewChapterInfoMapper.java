package com.novel.cn.dao.mapper;

import com.novel.cn.dao.entity.ChapterInfo;
import com.novel.cn.dao.entity.NewChapterInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LiZhong on 2018/9/14.
 */
public interface NewChapterInfoMapper {

    void saveNewChapterInfo(NewChapterInfo chapterInfo);

    void updateNewChapterInfoByNovelId(NewChapterInfo chapterInfo);

    ChapterInfo getNewChapterInfoByNovelId(@Param("novelId") String novelId, @Param("isPublish") String isPublish);

    NewChapterInfo getChapterInfoByNovelId(@Param("novelId") String novelId);

    /**
     * 将临时表小说最新章更新到正式最新章表
     * @param novelIds
     */
    void saveNewChapterFromNoPublishNewChapter(@Param("novelIds") List<String> novelIds);

}
