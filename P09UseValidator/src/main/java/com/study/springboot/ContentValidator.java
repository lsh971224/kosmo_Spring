package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ContentDTO.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ContentDTO dto = (ContentDTO)target;
		
		String writerP = dto.getWriter();
		if(writerP==null||writerP.trim().isEmpty()) {
			System.out.println("Writer is null or Empty");
			errors.rejectValue("writer", "null error");
		}
		
		String contentP = dto.getContent();
		if(contentP==null||contentP.trim().isEmpty()) {
			System.out.println("content is null or empty");
			errors.rejectValue("content", "null error");
		}
	}
}
