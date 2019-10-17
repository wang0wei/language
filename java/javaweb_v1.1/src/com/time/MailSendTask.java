package com.time;

import java.util.Date;
import java.util.TimerTask;

import com.email.SendMail;

public class MailSendTask extends TimerTask{
	public MailSendTask() {
		 
	 }
	 
	 /**
	   * RUN方法放入一个SCHEDULE的时候 进行执行 一个定时程序执行的进口
	  */
	  public void run(){//执行程序（调用SendMail发送邮件）
	 
	     System.out.println(new Date()+ "---MailSendTask begin to RUN ------------");
	     SendMail sd= new SendMail();
	     try {
		  sd.send();
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	 }
	 
}
