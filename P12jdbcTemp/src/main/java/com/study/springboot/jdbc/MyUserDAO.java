package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDAO {
	@Autowired //객체를 자동적으로 할당 해줌 
	private JdbcTemplate jdbcTemplate;

	public List<MyUserDTO> list() {
		String query = "select * from accounts";
		List<MyUserDTO> list = jdbcTemplate.query(query,
								new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
		
		for(MyUserDTO my : list) {
			System.out.println(my);
		}
		return list;
	}
		
	
}
