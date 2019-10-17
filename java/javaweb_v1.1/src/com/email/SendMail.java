package com.email;

import java.io.File;
import java.util.Properties;
import java.util.Set;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.sun.mail.util.MailSSLSocketFactory;
import com.yasuo.ZipCompressing;



public class SendMail {
	public void send() throws Exception{
		Properties prop = new Properties();
        // 开启debug调试，以便在控制台查看
        prop.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        prop.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        // 创建session
        Session session = Session.getInstance(prop);

        // 通过session得到transport对象
        Transport ts = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，授权码（更安全）
        ts.connect("smtp.qq.com", "956457912", "pcikbqdejemcbebf"); // 后面的字符是授权码

        // 创建邮件
        Message message = createSimpleMail(session);
        // 发送邮件
        if(message!=null) {
        	ts.sendMessage(message, message.getAllRecipients());
        	ts.close();
	    }
}

    /**
     * @Method: createSimpleMail
     */
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
    	/*没交齐之前只发文本邮件*/
    	
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("956457912@qq.com"));
        
        //获取收件人邮箱地址
        UserDao ud = new UserDaoImpl();
		Set<String> st = ud.findEmail();
		StringBuffer emails = ud.PassValue(st);
		
		if(emails.length()!=0) {  //如果长度不为零则代表，数据库中is_push不都为1（有人没交）
			String email = emails.toString();
			if(null != st && !st.isEmpty()){
				/*密送（接收的任何人看不到其他人*/
				@SuppressWarnings("static-access")
				InternetAddress[] internetAddressBCC = new InternetAddress().parse(email);
				message.setRecipients(Message.RecipientType.BCC, internetAddressBCC);  //密送地址建立
        }

        // 邮件的标题
        message.setSubject("作业通知");
        // 邮件的文本内容
        message.setContent("要交作业了","text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
        
    }else {  //如果为0（除了不为0，就只能为0），执行以下步骤
    	/*实现压缩操作*/
    	ZipCompressing book = new ZipCompressing();
    	book.zip("C:\\Users\\95645\\Desktop\\yasuoceshi1.zip",new File("C:\\Users\\95645\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\javaweb_v1.1\\upload"));
    	//压缩完成
    	
    	System.out.println("全部交齐");
    	//定义信息
    	message.setContent("所有成员作业已上交，请查阅","text/html;charset=UTF-8");
    	//收件人
    	message.addRecipient(Message.RecipientType.BCC, new InternetAddress("956457912@qq.com"));
    	// 创建消息部分
    	message.setSubject("作业通知");//主题
        BodyPart messageBodyPart = new MimeBodyPart();	 
    	// 消息
    	messageBodyPart.setText("所有成员作业已上交，请查阅");
    	
    	// 创建多重消息,为了添加邮件
    	Multipart multipart = new MimeMultipart();
    	// 设置文本消息部分
    	multipart.addBodyPart(messageBodyPart);
    	// 附件部分
    	messageBodyPart = new MimeBodyPart();
    	
    	//设置要发送附件的文件路径
    	String filename = "C:\\Users\\95645\\Desktop\\yasuoceshi1.zip";
    	DataSource source = new FileDataSource(filename);
    	messageBodyPart.setDataHandler(new DataHandler(source));
    		         
    	//messageBodyPart.setFileName(filename);
    	//处理附件名称中文（附带文件路径）乱码问题
    	messageBodyPart.setFileName(MimeUtility.encodeText(filename));  //需要的时候再改
    	multipart.addBodyPart(messageBodyPart);
    		 
    	//添加到一起
    	message.setContent(multipart );
        return message;
    }	
  }
}
