package com.novel.cn.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * 【作者】: Miaohw
 * 【日期】：2018-08-02 9:52
 * 【描述】：签约信息枚举
 */
@Slf4j
public enum NovelSignInfoEnum {

    EnumError("0","0"),
    /*******签签约类型：buyoff：买断签约，bottom：保底签约，divide：分成签约*******/
    BuyOffContract("buyoff", "买断签约"),
    BottomContract("bottom", "保底签约"),
    DivideContract("divide", "分成签约"),
    /*****是否申请付费上架 未申请/驳回: notapply，申请中：applying，审批通过：applyed）**/
    NotApply("notapply", "未申请/驳回"),
    Applying("applying", "申请中"),
    Applyed("applyed", "审批通过"),
    /******付费上架是否编辑 notedit：未编辑，edited: 已编辑*/
    NotEdit("notedit", "未编辑"),
    Edited("edited", "已编辑"),
    /*******是否发放签约奖励（notgrant，没有，granted 已发放）**/
    NotGrant("未发放", "notgrant"),
    Granted("已发放", "granted"),
    /** 公告管理*/
    PublishStatus("publishStatus","1"),
    NoPublishStatus("noPublishStatus","0"),
    /*****作评等级全勤奖励 元/千字**/
    AddCReward("C#A","3"),
    AddBReward("B#A","6"),
    AddAReward("A#A","9"),
    AddSReward("S#A","12"),
    /******全勤奖励扣除金额 元/天************/
    reduceCReward("C#R","30"),
    reduceBReward("B#R","75"),
    reduceAReward("A#R","120"),
    reduceSReward("S#R","180"),
    /********每日奖励计算上传字数上下限*******************/
    UpWords("upWords", "10000"),
    DownWords("downWords", "5000"),
    /******更新狂徒奖励  ************/
    oneRewardRMB("one", "1500"),
    twoRewardRMB("two", "1000"),
    threeRewardRMB("three", "800"),
    fourRewardRMB("four", "500"),
    fiveRewardRMB("five", "200"),
    sixToTenRewardYDB("sixToTen", "10000"),
    sevenToTwentyRewardYDB("sevenToTwenty", "5000"),
    /*******签约奖励发放****/
    GrantReward("GrantReward", "6666"); // 阅读币个数

    private String typeValue;
    private String type;

    NovelSignInfoEnum(String type, String typeValue){
        this.type = type;
        this.typeValue = typeValue;
    }

    /**
     * 根据值key获取枚举值
     * */
    public static String getTypeValueByType(String type){
        for( NovelSignInfoEnum infoEnum : NovelSignInfoEnum.values()){
            if(infoEnum.getType().equals(type)){
                return infoEnum.getTypeName();
            }
        }
        return "";
    }
    /*将字符串转换成Integer*/
    public static Integer getIntegerValue(String type) {

        return Integer.parseInt(getTypeValueByType(type));
    }

    public String getTypeName() {
        return typeValue;
    }

    public void setTypeName(String typeName) {
        this.typeValue = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
        String typeValueByType = getTypeValueByType("C#R");
        System.out.println("-----------"+typeValueByType);
    }
}
