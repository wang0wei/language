package com.servlet;

import java.util.Timer;
import com.time.MailSendTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;



/**
 * @Title:监听器接口实现类
 * @Description:网页刚打开便开始计时监听，执行监听实现类里面的操作
 * @Company:505工作小组
 * @author 505
 * @version v1.1
 */
@SuppressWarnings("all")  //抑制警告信息
public class MailSendListener extends HttpServlet implements
ServletContextListener {
		 /**
		    * 监听开始销毁
		   */
		   public void contextDestroyed(ServletContextEvent sce) {  //关闭网页销毁
		 	  System.out.println("作业上交完毕");
		  }
		  
		  /**
		    * 监听开始执行
		   */
		   public void contextInitialized(ServletContextEvent sce) {
		  
		   // 当监听开始执行时,设置一个TIME
		    Timer timer = new Timer();
		    System.out.println("-------MailSend   Timer开始进行执行--------------");
		    MailSendTask msendTask = new MailSendTask();
		    timer.schedule(msendTask, 60 * 1000, 5 * 1000);  //第一个时间是网页刚打开进行第一次操作，第二个时间是间隔时间
		    System.out.println("-------MailSend   Timer已经在执行--------------");
		   }

}
