package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(Model model) {
		System.out.println("ִ��demo");
		model.addAttribute("model","���Ƕ������");
		return "index.jsp";
	}
}
