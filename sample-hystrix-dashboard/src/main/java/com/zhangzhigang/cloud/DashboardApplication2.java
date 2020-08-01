package com.zhangzhigang.cloud;

import java.util.HashSet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApplication2 {

	public static void main(String[] args) {
//		SpringApplication.run(DashboardApplication2.class, args);
		 HashSet<StringBuilder> hs=new HashSet<StringBuilder>();
	        StringBuilder sb1=new StringBuilder("aaabbb");
	        StringBuilder sb2=new StringBuilder("aaabbb");
	        hs.add(sb1);
	        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
	 
//	        StringBuilder sb3=sb1;
//	        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
	        System.out.println(hs);
	}

}