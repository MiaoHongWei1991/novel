package com.novel.cn.service.userfeign;

import com.novel.cn.dao.entity.base.User;
import com.novel.cn.service.userfeign.hystrix.HystrixAuthorFallbackFactory;
import com.novel.cn.utils.AjaxPageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="${user.service.name}" , fallbackFactory = HystrixAuthorFallbackFactory.class)
public interface UserFeignService {
	@RequestMapping(value ="/feign/addUserBatch",method = RequestMethod.POST)
	AjaxPageResult addUserBatch(@RequestBody List<User> userList);

	@RequestMapping(value ="/feign/updateUserBatch",method = RequestMethod.POST)
	AjaxPageResult updateUserBatch(@RequestBody List<User> userList);

	@RequestMapping(value = "/feign/validAccountIsExist", method = RequestMethod.POST)
	AjaxPageResult validAccountIsExist(@RequestBody User user);

	@RequestMapping(value = "/feign/getUserInfo", method = RequestMethod.GET)
	AjaxPageResult getUserInfo(@RequestParam(value = "userId", required = false) Long userId);
}
