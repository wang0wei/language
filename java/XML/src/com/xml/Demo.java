package com.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo {

	//DOM解析xml文件
	public static void main(String[] args) {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 创建一个DocumentBuilder的对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
			Document document = db.parse("books.xml");
			// 获取所有book节点的集合
			NodeList booklist = document.getElementsByTagName("book");
			// 通过Nodelist的getlength（）方法获取booklist的长度
			System.out.println("一共有" + booklist.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < booklist.getLength(); i++) {
				System.out.println("============下面开始遍历第"+(i+1)+"本书的内容============");
				// 通过item(i)方法 获取一个book节点，NodeList的索引从0开始
				Node book = booklist.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(int index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名" + attr.getNodeName());
					// 获取属性值
					System.out.println("---属性值" + attr.getNodeValue());

				}
				//前提：知道book节点有且只能有1个id属性
				//将book节点进行强制类型转换，转换成Element类型
//				Element book=(Element)booklist.item(i);
//				String attrValue=book.getAttribute("id");
//				System.out.println("id属性的属性值为"+attrValue);
				
				//解析book节点的子节点
				NodeList childNodes=book.getChildNodes();
				//遍历childNode获取每个节点的节点名和节点值
				System.out.println("第"+(i+1)+"本书共有"+childNodes.getLength()+"个子节点");
				
			    //一共有九个字节点，其中每个换行和空白算一个节点
				for(int k=0;k<childNodes.getLength();k++) {
					//System.out.println(childNodes.item(k).getNodeName());//#text是换行和空格组成的
					//区分出text类型的node以及element类型的node
					if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE) {
						//获取了element类型节点的节点名
						System.out.print("第"+(k+1)+"个节点的节点名:"+childNodes.item(k).getNodeName());
						//获取了element类型节点的节点值
						//System.out.println("---节点值是："+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("---节点值是："+childNodes.item(k).getTextContent());
					
					}
				}
				System.out.println("============结束遍历第"+(i+1)+"本书的内容============");
			}
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
