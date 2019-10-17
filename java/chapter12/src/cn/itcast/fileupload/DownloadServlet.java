package cn.itcast.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ContentType�ֶ�ֵ
		response.setContentType("text/html;charset=utf-8");
		//������Ӧ��Ϣ����
		response.setCharacterEncoding("utf-8");
		//����������Ϣ����
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ҫ���ص��ļ�����
		String filename=request.getParameter("filename");
		//���ļ����Ʊ���
		filename=new String(filename.trim().getBytes("utf-8"),"utf-8");
		//�����ļ�����Ŀ¼
		String folder="/download/";
		//֪ͨ����������صķ�ʽ��
		response.addHeader("Content-Type", "application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"utf-8"));
		//ͨ���ļ�����ȡ�ļ�
		InputStream in=getServletContext().getResourceAsStream(folder+filename);
		//��ȡresponse����������
		OutputStream out=response.getOutputStream();
		byte[] buffer=new byte[1024];
		int len;
		//ѭ��ȡ�����е�����
		while((len=in.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
		
		
	}

}
