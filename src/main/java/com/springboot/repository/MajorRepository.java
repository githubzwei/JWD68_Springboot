package com.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.model.MajorBean;

@Repository
public class MajorRepository {
	
	@Autowired
	private JdbcTemplate jdbc;

	public int insertMajor(MajorBean obj) {
		int i=0;
		
		String sql = "insert into major(major_name,marks) values(?,?)";
		i=jdbc.update(sql,obj.getMajorName(),obj.getMarks());
		
		
		return i;
	}
	
	public List<MajorBean> getAllMajors(){
		List<MajorBean> list = new ArrayList<MajorBean>();
		
		String sql = "SELECT * FROM major where delete_flag=1";

		list =jdbc.query(
				sql, 
				(rs,rowCount)->
				new MajorBean(
						rs.getInt("id"), 
						rs.getString("major_name"), 
						rs.getInt("marks"))
				);
		
		
		return list;
	}
	
	public MajorBean getbyMajorId(int majorId) {
		MajorBean majorObj = null;

		String sql = "SELECT * FROM major where id=?";
		
		majorObj=jdbc.queryForObject(
				sql, 
				(rs,rowCount)-> new MajorBean
								(
								rs.getInt("id"), 
								rs.getString("major_name"), 
								rs.getInt("marks")
								),
				majorId
				);
		
		
		return majorObj;
	}
	
	
	
}

