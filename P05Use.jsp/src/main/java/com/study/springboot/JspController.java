package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {
	
	@RequestMapping("/")  //url창에 매핑시켜주는거 
	public @ResponseBody String root() { //@ResponseBody 
		return "JSP";
	}
	@RequestMapping("/test1")
	public String test1() {
		return "test";  //test.jsp인거임 
	}
	@RequestMapping("/test2")
	public String test2() {
		return "sub/test1";  //sub/test1.jsp인거임
	}
	
}
