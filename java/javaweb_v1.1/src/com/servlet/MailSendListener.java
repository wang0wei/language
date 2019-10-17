package com.servlet;

import java.util.Timer;
import com.time.MailSendTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;



/**
 * @Title:�������ӿ�ʵ����
 * @Description:��ҳ�մ򿪱㿪ʼ��ʱ������ִ�м���ʵ��������Ĳ���
 * @Company:505����С��
 * @author 505
 * @version v1.1
 */
@SuppressWarnings("all")  //���ƾ�����Ϣ
public class MailSendListener extends HttpServlet implements
ServletContextListener {
		 /**
		    * ������ʼ����
		   */
		   public void contextDestroyed(ServletContextEvent sce) {  //�ر���ҳ����
		 	  System.out.println("��ҵ�Ͻ����");
		  }
		  
		  /**
		    * ������ʼִ��
		   */
		   public void contextInitialized(ServletContextEvent sce) {
		  
		   // ��������ʼִ��ʱ,����һ��TIME
		    Timer timer = new Timer();
		    System.out.println("-------MailSend   Timer��ʼ����ִ��--------------");
		    MailSendTask msendTask = new MailSendTask();
		    timer.schedule(msendTask, 60 * 1000, 5 * 1000);  //��һ��ʱ������ҳ�մ򿪽��е�һ�β������ڶ���ʱ���Ǽ��ʱ��
		    System.out.println("-------MailSend   Timer�Ѿ���ִ��--------------");
		   }

}
