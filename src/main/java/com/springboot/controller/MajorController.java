package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.MajorBean;
import com.springboot.repository.MajorRepository;

@Controller
@RequestMapping("/major")
public class MajorController {
	
	@Autowired
	private MajorRepository mRepo;

	@GetMapping("/form")
	public ModelAndView showForm() {
		return new ModelAndView("create-major","majorObj",new MajorBean());
	}
	
	@PostMapping("/create")
	public String createMajor(@ModelAttribute("majorObj") MajorBean obj,Model m) {
		
		int i = mRepo.insertMajor(obj);
		if(i!=0) {
			return "redirect:list";
		}else {
			m.addAttribute("fail","insert fail!");
			return "redirect:form";
		}
		
	}
	
	@GetMapping("/list")
	public String showAllMajors(Model m) {
		List<MajorBean> list =mRepo.getAllMajors();
		m.addAttribute("majorList", list);
		return "major-list";
	}
	
	@GetMapping("/getbyid")
	public ModelAndView getById(@RequestParam("id")Integer majorId) {
		MajorBean obj = mRepo.getbyMajorId(majorId);
		return new ModelAndView("major-edit","majorObj",obj);
		
	}
	
}
