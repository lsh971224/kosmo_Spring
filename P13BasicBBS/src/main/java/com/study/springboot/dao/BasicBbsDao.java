package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.BasicBbsDTO;

@Repository
public class BasicBbsDao implements IBasicBbsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BasicBbsDTO> listDao() {
		System.out.println("listDao()");
		String query = "select * from basic_bbs order by id desc";
		List<BasicBbsDTO> dtos = 
					jdbcTemplate.query(query,  //query = 다중으로 받는거
								new BeanPropertyRowMapper<BasicBbsDTO>(BasicBbsDTO.class));
		return dtos;
	} 	

	@Override
	public BasicBbsDTO viewDao(String id) {
		System.out.println("viewDao()");
		String query = "select * from basic_bbs where id = "+id;
		BasicBbsDTO dto = jdbcTemplate.queryForObject(query, //queryForObject-> 단일 쿼리만
							new BeanPropertyRowMapper<BasicBbsDTO>(BasicBbsDTO.class));
		return dto;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		String query = "insert into basic_bbs(id,writer,title,content) "+
					"values(basic_bbs_seq.nextval,?,?,?)";
		
		return jdbcTemplate.update(query,writer,title,content); //성공하면 1반환
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		String query = "delete from basic_bbs where id = ?";
		
		return jdbcTemplate.update(query,Integer.parseInt(id));
	}

}
