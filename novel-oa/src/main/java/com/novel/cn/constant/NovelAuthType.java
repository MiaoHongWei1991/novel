package com.novel.cn.constant;

/**
 * 授权类型
 * Created by LiZhong on 2018/8/1.
 */
public enum NovelAuthType {
    station(0),     //驻站作品
    exclusive(1);   //独家作品

    private Integer type;

    NovelAuthType(Integer type) {
        this.type = type;
    }

    public Integer getAuthType() {
        return this.type;
    }

}
