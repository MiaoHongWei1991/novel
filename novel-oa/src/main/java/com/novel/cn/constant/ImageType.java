package com.novel.cn.constant;

/**
 * 封面类型
 * Created by LiZhong on 2018/7/31.
 */
public enum ImageType {
    across("1"),        //横屏封面
    vertical("0");      //竖屏封面

    private String type;

    ImageType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
