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
        // ����debug���ԣ��Ա��ڿ���̨�鿴
        prop.setProperty("mail.debug", "true");
        // �����ʼ�������������
        prop.setProperty("mail.host", "smtp.qq.com");
        // ���ͷ�������Ҫ�����֤
        prop.setProperty("mail.smtp.auth", "true");
        // �����ʼ�Э������
        prop.setProperty("mail.transport.protocol", "smtp");

        // ����SSL���ܣ������ʧ��
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        // ����session
        Session session = Session.getInstance(prop);

        // ͨ��session�õ�transport����
        Transport ts = session.getTransport();
        // �����ʼ����������������ͣ��ʺţ���Ȩ�루����ȫ��
        ts.connect("smtp.qq.com", "956457912", "pcikbqdejemcbebf"); // ������ַ�����Ȩ��

        // �����ʼ�
        Message message = createSimpleMail(session);
        // �����ʼ�
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
    	/*û����֮ǰֻ���ı��ʼ�*/
    	
        // �����ʼ�����
        MimeMessage message = new MimeMessage(session);
        // ָ���ʼ��ķ�����
        message.setFrom(new InternetAddress("956457912@qq.com"));
        
        //��ȡ�ռ��������ַ
        UserDao ud = new UserDaoImpl();
		Set<String> st = ud.findEmail();
		StringBuffer emails = ud.PassValue(st);
		
		if(emails.length()!=0) {  //������Ȳ�Ϊ����������ݿ���is_push����Ϊ1������û����
			String email = emails.toString();
			if(null != st && !st.isEmpty()){
				/*���ͣ����յ��κ��˿�����������*/
				@SuppressWarnings("static-access")
				InternetAddress[] internetAddressBCC = new InternetAddress().parse(email);
				message.setRecipients(Message.RecipientType.BCC, internetAddressBCC);  //���͵�ַ����
        }

        // �ʼ��ı���
        message.setSubject("��ҵ֪ͨ");
        // �ʼ����ı�����
        message.setContent("Ҫ����ҵ��","text/html;charset=UTF-8");
        // ���ش����õ��ʼ�����
        return message;
        
    }else {  //���Ϊ0�����˲�Ϊ0����ֻ��Ϊ0����ִ�����²���
    	/*ʵ��ѹ������*/
    	ZipCompressing book = new ZipCompressing();
    	book.zip("C:\\Users\\95645\\Desktop\\yasuoceshi1.zip",new File("C:\\Users\\95645\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\javaweb_v1.1\\upload"));
    	//ѹ�����
    	
    	System.out.println("ȫ������");
    	//������Ϣ
    	message.setContent("���г�Ա��ҵ���Ͻ��������","text/html;charset=UTF-8");
    	//�ռ���
    	message.addRecipient(Message.RecipientType.BCC, new InternetAddress("956457912@qq.com"));
    	// ������Ϣ����
    	message.setSubject("��ҵ֪ͨ");//����
        BodyPart messageBodyPart = new MimeBodyPart();	 
    	// ��Ϣ
    	messageBodyPart.setText("���г�Ա��ҵ���Ͻ��������");
    	
    	// ����������Ϣ,Ϊ������ʼ�
    	Multipart multipart = new MimeMultipart();
    	// �����ı���Ϣ����
    	multipart.addBodyPart(messageBodyPart);
    	// ��������
    	messageBodyPart = new MimeBodyPart();
    	
    	//����Ҫ���͸������ļ�·��
    	String filename = "C:\\Users\\95645\\Desktop\\yasuoceshi1.zip";
    	DataSource source = new FileDataSource(filename);
    	messageBodyPart.setDataHandler(new DataHandler(source));
    		         
    	//messageBodyPart.setFileName(filename);
    	//�������������ģ������ļ�·������������
    	messageBodyPart.setFileName(MimeUtility.encodeText(filename));  //��Ҫ��ʱ���ٸ�
    	multipart.addBodyPart(messageBodyPart);
    		 
    	//��ӵ�һ��
    	message.setContent(multipart );
        return message;
    }	
  }
}
