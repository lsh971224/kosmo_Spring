package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	@RequestMapping("/uploading")
	public @ResponseBody String uploading(HttpServletRequest req) {
		int size = 1024*1024*10; //10MB
		String file ="";
		String oriFile = "";
		
		JSONObject obj = new JSONObject();
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			System.out.println(path);
			
			MultipartRequest multi = new MultipartRequest(req, path,size,"UTF-8",new DefaultFileRenamePolicy());
			
		}catch(Exception e) {
			
		}
		
		
	}
}
