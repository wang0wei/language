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
 * �Զ���MVC��ܣ�����servletʵ�ֵĿ�����
 * */


public class Controller extends HttpServlet  {
//�����ɿ�����controllerά����Actionӳ�䣬���б������е�Actionʵ��
	private HashMap actionMap;
	
	
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
        //��ʼ��actionMap
		actionMap=new HashMap();
		//��AddAction������뵽actionMap��
		actionMap.put("add", new AddAction());
	}

	//����path�ж����ĸ�actionִ�в���
	private Action determinActionByPath(String path) {
		//�磺��http://localhost:8080/ch01/add.action�еõ�add
		String actionName=path.substring(path.lastIndexOf('/')+1,path.length()-7);
		//��ø������Ӧ��action����
		Action ret=(Action)actionMap.get(actionName);
		return ret;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ�path�����磺http://localhost:8080/ch01/ShowBaby.action
		String path=request.getServletPath();
		//�ҳ�Action
		Action action=(Action)this.determinActionByPath(path);
		//ִ�в���
		String resultView=action.execute(request, response);
		//����ҳ��ת��
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
