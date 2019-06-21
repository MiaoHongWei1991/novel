package com.novel.cn.dao.mapper;

import com.novel.cn.dao.entity.TblNovelTaskRun;
import org.apache.ibatis.annotations.Param;

/**
 * 定时任务记录接口
 * zhaolei 2018/9/1018:12
 */
public interface TblNovelTaskRunMapper {

    /**
     * 根据方法名查询最后执行方法对象
     * zhaolei 18:22 2018/9/10
     */
    TblNovelTaskRun queryFinalExecution(String methodName);

    /**
     * 新增定时任务执行记录
     * zhaolei 18:34 2018/9/10
     */
    int insertExecutionRun(@Param("tblNovelTaskRun") TblNovelTaskRun tblNovelTaskRun);


}
