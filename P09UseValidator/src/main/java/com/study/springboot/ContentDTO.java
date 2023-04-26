package com.study.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContentDTO {
	private int id;
	private String writer;
	private String content;
}
