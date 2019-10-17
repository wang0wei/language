package com.haiersoft.ch01.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haiersoft.ch01.biz.Calculator;
import com.haiersoft.ch01.framework.Action;

public class AddAction  implements Action{

	//ҵ���߼�����
	private Calculator biz=new Calculator();
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		//���ҳ������
		double num1=Double.parseDouble(request.getParameter("num1"));
		double num2=Double.parseDouble(request.getParameter("num2"));
		//����ҵ���߼�����,��÷���ֵ
		double result=biz.add(num1, num2);
		//�����������request��,�Ա���ҳ���еõ�
		request.setAttribute("result", result);
		//���ؽ�Ҫת������ҳ��·��
		return "add_result.jsp";
	}
}
