package com.novel.cn.constant;

public enum NovelCheckType {

    NOVEL(1),     //书籍审核
    CHAPTER(2),   //章节审核
    AUTHOR(3),    //作者审核
    SIGN(4),      //信息补录(签约)
    PAYPREFER(5); //付费上架

    private Integer type;

    NovelCheckType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}