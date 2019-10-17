package com.bjsxt.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping("demo1")
	public String demo1(HttpServletRequest abc,HttpSession sessionParam) {
		//request作用域
		abc.setAttribute("req", "req的值");
		//session作用域
		HttpSession session=abc.getSession();
		session.setAttribute("session", "session的值");
		sessionParam.setAttribute("sessionParam", "sessionParam的值");
		//application作用域
		ServletContext application = abc.getServletContext();
		application.setAttribute("application", "application的值");
		return "/index.jsp";
	}
	
	@RequestMapping("demo2")
	public String demo2(Map<String,Object> map) {
		System.out.println(map.getClass());
		map.put("map", "map的值");
		return "/index.jsp";
	}
	
	@RequestMapping("demo3")
	public String demo3(Model model) {
		model.addAttribute("model", "model的值");
		return "/index.jsp";
	}
	
	@RequestMapping("demo4")
	public ModelAndView demo4() {
		//参数，跳转视图
		ModelAndView mav=new ModelAndView("/index.jsp");
		mav.addObject("mav","mav的值");
		return mav;
	}
}
