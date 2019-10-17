package com.yasuo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressing {
	 private int k = 1; // 定义递归次数变量
	    //zipFileName:保存压缩文件的路径+压缩文件名                          inputFile:压缩文件夹的路径
   public void zip(String zipFileName, File inputFile) throws Exception {
	        System.out.println("压缩中...");
	        //ZipOutputStream ：DeflaterOutputStream的一个子类，把数据压缩成Zip文件格式。
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
	        
	        //BufferedOutputStream是缓冲输出流,继承于FilterOutputStream,作用是为另一个输出流提供“缓冲功能”
	        //为ZipOutputStream提供一个缓冲输出流
	        BufferedOutputStream bo = new BufferedOutputStream(out);
	        
	        // inputFile.getName()得到压缩文件夹名
	        zip(out, inputFile, inputFile.getName(), bo);
	        
	        bo.close();
	        out.close(); // 输出流关闭
	        System.out.println("压缩完成");
	    }
	    
		//递归，获取需要压缩的文件夹下面的所有子文件,然后创建对应目录与文件,对文件进行压缩
	    private void zip(ZipOutputStream out, File f, String base,
	            BufferedOutputStream bo) throws Exception { // 方法重载
	        if (f.isDirectory()){//文件目录存在
	        	//File.listFiles()返回值类型,File对象数组 ;数组中元素内容,File对象类型的【完整路径】
	            File[] fl = f.listFiles();
	            
	            if (fl.length == 0){//如果文件夹没有子文件
	            	//ZipEntry 压缩文件的子文件对象，用于保存压缩文件中文件及其文件夹的一个实列
	            	//ZipEntry就是压缩包中的每一个实体
	                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
	                System.out.println(base + "/");
	            }
	            //文件夹有子文件,递归遍历子文件
	            for (int i = 0; i < fl.length; i++) {
	                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
	            }
	            System.out.println("第" + k + "次递归");
	            k++;
	        }
	       else {//文件目录不存在
	    //putNextEntry(ZipEntry e);该函数用于添加一个压缩子文件或子文件夹，它需要一个ZipEntry对象。
	    //举一个例子说名该函数，如果在压缩文件中创建一个子文件夹，那么就是putNextEntry(new ZipEntry("Test/"));
	    //该语句就会在压缩文中，添加一个Test文件夹，注意，如果没有"/"，那么将创建一个Test文件。

                out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
	            System.out.println(base);
	            FileInputStream in = new FileInputStream(f);
	            BufferedInputStream bi = new BufferedInputStream(in);
	            int b;
	            while ((b = bi.read()) != -1) {
	                bo.write(b); // 将字节流写入当前zip目录
	            }
	            bo.flush();//不加这个函数会使数据丢失
	            bi.close();
	            in.close(); // 输入流关闭
	        }
	    }
	    /**
	     * 测试
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
