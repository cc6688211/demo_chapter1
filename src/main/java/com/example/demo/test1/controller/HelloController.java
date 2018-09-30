package com.example.demo.test1.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

//Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
//如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
@RestController
@ApiIgnore
public class HelloController {

	@Value("${com.tit.properties.params.random4}")
	private int random;

	// Spring mvc的注解，起到路由作用
	@RequestMapping("/hello")
	public Map<String, Object> index() {
		Map<String, Object> test = new HashMap<String, Object>();
		test.put("path", "/hello");
		test.put("date", new Date());
		test.put("random", random);
		return test;
	}
}
