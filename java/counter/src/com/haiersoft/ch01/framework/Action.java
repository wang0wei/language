package com.haiersoft.ch01.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
//����ýӿڵ�ʵ�������ʵ�ֵ�execute����
	String execute(HttpServletRequest request,HttpServletResponse response);
}
