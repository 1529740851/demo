package com.example.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//定时器
@Component 
public class Dingshi {
	 @Scheduled(cron="0 0/1 * * * ?") //一分钟执行一次
	public void dinshi(){
		System.out.println("1111111");
	}
	
}
