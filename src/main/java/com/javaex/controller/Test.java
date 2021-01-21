package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("테스트");
		
		return "/WEB-INF/views/test.jsp";
	}

}
