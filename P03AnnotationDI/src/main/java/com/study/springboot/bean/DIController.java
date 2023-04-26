package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DIController {
	@Autowired
	Member member1; 
	@Autowired
	@Qualifier("printerB") // -> Printer는 bean객체가 2개니까 그 값에 해당하는걸 부를떄 @Qualfier("값")을 해줘야돼
	Printer printer;
	@Autowired
	Member member2;
	
	@RequestMapping("/") 
	public @ResponseBody String root() {
		member1.print();
		member1.setPrinter(printer);
		member1.print();
		if(member1==member2) {
			System.out.println("동일객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		return "Annotation 사용";
	}
	
}