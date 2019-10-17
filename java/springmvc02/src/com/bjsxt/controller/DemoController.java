package com.bjsxt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Demo;
import com.bjsxt.pojo.People;

@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(@RequestParam(value="name1")String name,@RequestParam(value="age1")int age) {
		System.out.println("执行demo"+name+" "+age);
		return "main.jsp";
	}
	
	@RequestMapping("page")
	public String page(@RequestParam(defaultValue = "2")int pageSize,@RequestParam(defaultValue = "1")int pageNumber) {
		System.out.println(pageSize+" "+pageNumber);
		return "main.jsp";
	}
	
	@RequestMapping("demo2")
	public String demo2(@RequestParam(required=true)String name) {
		System.out.println("name是SQL的查询条件,必须要传递name参数"+name);
		return "main.jsp";
	}
	
	@RequestMapping("demo3")
	public String demo3(@RequestParam(required=true,defaultValue = "测试")String name) {
		System.out.println(name);
		return "main.jsp";
	}
	
	@RequestMapping("demo4")
	public String demo4(People peo) {
		return "main.jsp";
	}
	
	@RequestMapping("demo5")
	public String demo5(String name,int age,@RequestParam("hover")List<String> abc) {
		System.out.println(name+" "+age+" "+abc);
		return "main.jsp";
	}
	
	@RequestMapping("demo6")
	public String demo6(Demo demo) {
		System.out.println(demo);
		return "main.jsp";
	}
	
	@RequestMapping("demo7")
	public String demo7(String name,int age) {
		System.out.println(name+" "+age);
		return "main.jsp";
	}
	
	@RequestMapping("demo8/{age1}/{name}")
	public String demo8(@PathVariable String name,@PathVariable(value="age1") int age) {
		System.out.println(name+" "+age);
		return "/main.jsp";
	}
	
	@RequestMapping("demo9")
	public String demo9() {
		System.out.println("转发");
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("demo10")
	public String demo10() {
		return "forward:demo11";
	}
	
	@RequestMapping("demo11")
	public String demo11() {
		System.out.println("demo11");
		return "main";
	}
	
	@RequestMapping(value="demo12",produces="text/html;charset=utf-8")
	@ResponseBody
	public String demo12() throws IOException {
		People p=new People();
		p.setAge(12);
		p.setName("张三");
		return "中文";
	}
}
