package com.novel.cn.constant;

public enum NovelAuthStatus {

    DISABLE(0),  //禁用
    NORMAL(1),   //正常
    CHECK(2),    //审核
    REJECT(3);   //驳回

    private Integer code;

    NovelAuthStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
