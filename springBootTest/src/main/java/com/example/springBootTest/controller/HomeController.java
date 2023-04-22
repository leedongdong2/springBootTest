package com.example.springBootTest.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBootTest.mapper.HomeMapper;

@RestController
public class HomeController {
	
	@Autowired
	HomeMapper homeMapper;
	
	@GetMapping("/home")
	public ModelAndView home(ModelAndView mv,@RequestParam HashMap<String,Object> param) {
		
		List<HashMap<String,Object>> list = homeMapper.lunchList();
		mv.addObject("list",list);
		mv.addObject("param", param);
		mv.setViewName("home");
		return mv;
	}

}
