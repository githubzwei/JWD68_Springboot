package com.springboot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.model.ClassBean;
import com.springboot.model.MajorBean;

@Repository
public class ClassRepository {
	
	@Autowired
	private JdbcTemplate jdbc;

	public int insertClass(ClassBean obj) {
		int i[][]=null;
		
		String sql = "insert into class(teacher_id,student_id) values(?,?)";
		i=jdbc.batchUpdate
				(
				sql,
				Arrays.asList(obj.getTeacherIds()),
				obj.getTeacherIds().length,
				(ps,teacherId)->{
					 ps.setInt(1, teacherId);
			         ps.setInt(2, obj.getStudentId());
				});
		
		int count = 0;

	    for (int[] batch : i) {
	        for (int value : batch) {
	            count += value;
	        }
	    }
		
		
		return count;
	}
	
	
	
	
}

