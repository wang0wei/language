package com.haiersoft.ch01.framework;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haiersoft.ch01.action.AddAction;

/*
 * 自定义MVC框架：基于servlet实现的控制器
 * */


public class Controller extends HttpServlet  {
//声明由控制器controller维护的Action映射，其中保存所有的Action实例
	private HashMap actionMap;
	
	
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
        //初始化actionMap
		actionMap=new HashMap();
		//将AddAction对象放入到actionMap中
		actionMap.put("add", new AddAction());
	}

	//根据path判断由哪个action执行操作
	private Action determinActionByPath(String path) {
		//如：从http://localhost:8080/ch01/add.action中得到add
		String actionName=path.substring(path.lastIndexOf('/')+1,path.length()-7);
		//获得该请求对应的action对象
		Action ret=(Action)actionMap.get(actionName);
		return ret;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到path，诸如：http://localhost:8080/ch01/ShowBaby.action
		String path=request.getServletPath();
		//找出Action
		Action action=(Action)this.determinActionByPath(path);
		//执行操作
		String resultView=action.execute(request, response);
		//控制页面转向
		if(null!=resultView) {
			request.getRequestDispatcher(resultView).forward(request, response);	
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
