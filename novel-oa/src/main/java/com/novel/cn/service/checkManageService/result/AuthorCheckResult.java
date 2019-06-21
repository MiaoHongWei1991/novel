package com.novel.cn.service.checkManageService.result;


import lombok.Data;

/**
 * @author dailong
 * @ClassName: AuthorCheckResult
 * @Description: TODO
 * @date 2018/10/10 下午4:24
 */
@Data
public class AuthorCheckResult{

    private Long id;                //id
    private Long userId;            //账号id
    private String penName;         //笔名
    private String email;           //邮箱
    private String qq;              //qq号
    private String name;            //真实姓名
    private String sex;             //性别
    private String idCard;          //身份证号码
    private String phoneNum;        //电话号码
    private String province;        //所在省
    private String city;            //所在市
    private String area;            //所在县
    private String address;         //详细地址
    private String applyTime;       //申请时间
    private Integer status;         //状态
}
