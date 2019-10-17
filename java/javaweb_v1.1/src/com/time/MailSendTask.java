package com.time;

import java.util.Date;
import java.util.TimerTask;

import com.email.SendMail;

public class MailSendTask extends TimerTask{
	public MailSendTask() {
		 
	 }
	 
	 /**
	   * RUN��������һ��SCHEDULE��ʱ�� ����ִ�� һ����ʱ����ִ�еĽ���
	  */
	  public void run(){//ִ�г��򣨵���SendMail�����ʼ���
	 
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
