package com.springboot.team_one.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.team_one.dto.Product;
import com.springboot.team_one.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHome(HttpServletRequest req, Model model) {
		
		List<Product> list = service.listAll();
		model.addAttribute("list", list);
		return "index"; //타임리프를 사용하겠습니다! templates=>index.html
		
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest req, Model model) {
		return "main";
	}
	
	@RequestMapping("/123")
	public String viHome(Model model) {
		return "index";
	}
	
	@RequestMapping("/4124")
	public String vHome(Model model) {
		return "index";
	}

}
