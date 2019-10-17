package com.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt((String)request.getParameter("id"));
		String Name = request.getParameter("name");
		UserDao ud = new UserDaoImpl();
		ud.update(id);  //�޸�is_push
		
		
		try {
		    //����ContentType�ֶ�ֵ
		    response.setContentType("text/html;charset=utf-8");
			// ����DiskFileItemFactory��������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//�����ļ�����Ŀ¼�������Ŀ¼���������´���һ��
			File f = new File("C:\\TempFolder");
			if (!f.exists()) {
				f.mkdirs();
			}
			// �����ļ��Ļ���·��
			factory.setRepository(f);
			// ���� ServletFileUpload����
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			//�����ַ�����
			fileupload.setHeaderEncoding("utf-8");
			// ���� request���õ��ϴ��ļ���FileItem����
			List<FileItem> fileitems = fileupload.parseRequest(request);
			//��ȡ�ַ���
			PrintWriter writer = response.getWriter();
			// ��������
			for (FileItem fileitem : fileitems) {
				// �ж��Ƿ�Ϊ��ͨ�ֶ�
				if (fileitem.isFormField()) {
					// ����ֶ������ֶ�ֵ
					String name = fileitem.getFieldName();
					if(name.equals("name")){
						//����ļ���Ϊ�գ����䱣����value��
						if(!fileitem.getString().equals("")){
							String value = fileitem.getString("utf-8");
							writer.print("�ϴ��ߣ�" + value + "<br>");							
						}
					}
				} else {
					// ��ȡ�ϴ����ļ���
					String filename = fileitem.getName();
					//�����ϴ��ļ�
					if(filename != null && !filename.equals("")){
						writer.print("�ϴ����ļ������ǣ�" + filename + "<br>");						
						// ��ȡ���ļ���
						filename = filename.substring(filename.lastIndexOf("\\") + 1);						
						// �ļ�����ҪΨһ
						//UUID.randomUUID().toString()
						//Name = Name.
						filename =(String)Name + "_" + filename;
						// �ڷ���������ͬ���ļ�
						String webPath = "/upload/";
						//�����������ļ���·�����ļ�����ϳ������ķ�������·��
						String filepath = getServletContext().getRealPath(webPath + filename);
						// �����ļ�
						File file = new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						// ����ϴ��ļ���
						InputStream in = fileitem.getInputStream();
						// ʹ��FileOutputStream�򿪷������˵��ϴ��ļ�
						FileOutputStream out = new FileOutputStream(file);
						// ���ĶԿ�
						byte[] buffer = new byte[1024];//ÿ�ζ�ȡ1���ֽ�
						int len;
						//��ʼ��ȡ�ϴ��ļ����ֽڣ����������������˵��ϴ��ļ��������
						while ((len = in.read(buffer)) > 0)
							out.write(buffer, 0, len);
						// �ر���
						in.close();
						out.close();
						// ɾ����ʱ�ļ�
						fileitem.delete();
						writer.print("�ϴ��ļ��ɹ���<br>");
					}										
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
