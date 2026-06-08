package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.MajorBean;
import com.springboot.model.TeacherBean;
import com.springboot.repository.TeacherRepository;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherRepository tRepo;
	
	@GetMapping("/list")
	public String showAllTeachers(Model m) {
		List<TeacherBean> list =tRepo.getAllTeachers();
		m.addAttribute("teacherList", list);
		return "teacher-list";
	}
	
}
