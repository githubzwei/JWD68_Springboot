package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.ClassBean;
import com.springboot.model.MajorBean;
import com.springboot.model.TeacherBean;
import com.springboot.repository.TeacherRepository;

@Controller
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private TeacherRepository tRepo;
	
	@GetMapping("/form")
	public ModelAndView showForm(Model m) {
		List<TeacherBean> list =tRepo.getAllTeachers();
		m.addAttribute("teacherList", list);		
		return new ModelAndView("class-create","classObj",new ClassBean());
	}
	
	/*
	 * @PostMapping("/create") public String createClass(@ModelAttribute("majorObj")
	 * MajorBean obj,Model m) {
	 * 
	 * int i = mRepo.insertMajor(obj); if(i!=0) { return "redirect:list"; }else {
	 * m.addAttribute("fail","insert fail!"); return "redirect:form"; }
	 * 
	 * }
	 */
	
}
