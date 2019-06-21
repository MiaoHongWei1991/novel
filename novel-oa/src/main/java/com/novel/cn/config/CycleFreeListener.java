package com.novel.cn.config;

import com.novel.cn.scheduling.ScheduleConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author: YangYunHang
 * @Description:
 * @Date: 2018/7/11 18:21
 */
//@Component
@Slf4j
public class CycleFreeListener implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${default.cyclefree.cron}")
	private String default_cron;

	@Autowired
	private ScheduleConfig scheduleConfig;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("默认的cron:{}",default_cron);
		//采用默认的cron去执行小说的随机
		scheduleConfig.setDefault_cron(default_cron);
	}
}
