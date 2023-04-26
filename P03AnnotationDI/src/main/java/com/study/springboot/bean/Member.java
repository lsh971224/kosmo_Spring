package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //--> 컴포넌트 스캔을 하면 빈 컨테이너에서 확인함
public class Member {
	@Value("나문희") 
	private String name;
	@Value("호박고구마")
	private String nickName;
	@Autowired //객체는 Autowried로 설정  
	@Qualifier("printerA")
	private Printer printer;
	
	public Member() {}
	
	public Member(String name, String nickName, Printer printer) {
		this.name = name;
		this.nickName = nickName;
		this.printer = printer;
	}

	
	public void setName(String name) {
		this.name = name;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void print() {
		printer.print("안녕 !"+name+":"+nickName);
	}
	
	
}
