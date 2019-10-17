package com.yasuo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressing {
	 private int k = 1; // ����ݹ��������
	    //zipFileName:����ѹ���ļ���·��+ѹ���ļ���                          inputFile:ѹ���ļ��е�·��
   public void zip(String zipFileName, File inputFile) throws Exception {
	        System.out.println("ѹ����...");
	        //ZipOutputStream ��DeflaterOutputStream��һ�����࣬������ѹ����Zip�ļ���ʽ��
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
	        
	        //BufferedOutputStream�ǻ��������,�̳���FilterOutputStream,������Ϊ��һ��������ṩ�����幦�ܡ�
	        //ΪZipOutputStream�ṩһ�����������
	        BufferedOutputStream bo = new BufferedOutputStream(out);
	        
	        // inputFile.getName()�õ�ѹ���ļ�����
	        zip(out, inputFile, inputFile.getName(), bo);
	        
	        bo.close();
	        out.close(); // ������ر�
	        System.out.println("ѹ�����");
	    }
	    
		//�ݹ飬��ȡ��Ҫѹ�����ļ���������������ļ�,Ȼ�󴴽���ӦĿ¼���ļ�,���ļ�����ѹ��
	    private void zip(ZipOutputStream out, File f, String base,
	            BufferedOutputStream bo) throws Exception { // ��������
	        if (f.isDirectory()){//�ļ�Ŀ¼����
	        	//File.listFiles()����ֵ����,File�������� ;������Ԫ������,File�������͵ġ�����·����
	            File[] fl = f.listFiles();
	            
	            if (fl.length == 0){//����ļ���û�����ļ�
	            	//ZipEntry ѹ���ļ������ļ��������ڱ���ѹ���ļ����ļ������ļ��е�һ��ʵ��
	            	//ZipEntry����ѹ�����е�ÿһ��ʵ��
	                out.putNextEntry(new ZipEntry(base + "/")); // ����zipѹ�������base
	                System.out.println(base + "/");
	            }
	            //�ļ��������ļ�,�ݹ�������ļ�
	            for (int i = 0; i < fl.length; i++) {
	                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // �ݹ�������ļ���
	            }
	            System.out.println("��" + k + "�εݹ�");
	            k++;
	        }
	       else {//�ļ�Ŀ¼������
	    //putNextEntry(ZipEntry e);�ú����������һ��ѹ�����ļ������ļ��У�����Ҫһ��ZipEntry����
	    //��һ������˵���ú����������ѹ���ļ��д���һ�����ļ��У���ô����putNextEntry(new ZipEntry("Test/"));
	    //�����ͻ���ѹ�����У����һ��Test�ļ��У�ע�⣬���û��"/"����ô������һ��Test�ļ���

                out.putNextEntry(new ZipEntry(base)); // ����zipѹ�������base
	            System.out.println(base);
	            FileInputStream in = new FileInputStream(f);
	            BufferedInputStream bi = new BufferedInputStream(in);
	            int b;
	            while ((b = bi.read()) != -1) {
	                bo.write(b); // ���ֽ���д�뵱ǰzipĿ¼
	            }
	            bo.flush();//�������������ʹ���ݶ�ʧ
	            bi.close();
	            in.close(); // �������ر�
	        }
	    }
	    /**
	     * ����
	     */
//	    public static void main(String[] args) {
//	        ZipCompressing book = new ZipCompressing();
//	        try {
//	            book.zip("F:\\ziptest.zip",new File("F:\\ziptest"));
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
}
