package com.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.model.MajorBean;
import com.springboot.model.TeacherBean;

@Repository
public class TeacherRepository {
	
	@Autowired
	private JdbcTemplate jdbc;

	public List<TeacherBean> getAllTeachers(){
		List<TeacherBean> list = new ArrayList<TeacherBean>();
		
		String sql = "SELECT * FROM teacher";

		list =jdbc.query(
				sql, 
				(rs,rowCount)->
				new TeacherBean(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("position"), 
						rs.getString("department")
						)
				);
		return list;
	}
}
