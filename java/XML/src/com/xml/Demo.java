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

	//DOM����xml�ļ�
	public static void main(String[] args) {
		// ����һ��DocumentBuilderFactory�Ķ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// ����һ��DocumentBuilder�Ķ���
			DocumentBuilder db = dbf.newDocumentBuilder();
			// ͨ��DocumentBuilder�����parse��������books.xml�ļ�����ǰ��Ŀ��
			Document document = db.parse("books.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList booklist = document.getElementsByTagName("book");
			// ͨ��Nodelist��getlength����������ȡbooklist�ĳ���
			System.out.println("һ����" + booklist.getLength() + "����");
			// ����ÿһ��book�ڵ�
			for (int i = 0; i < booklist.getLength(); i++) {
				System.out.println("============���濪ʼ������"+(i+1)+"���������============");
				// ͨ��item(i)���� ��ȡһ��book�ڵ㣬NodeList��������0��ʼ
				Node book = booklist.item(i);
				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("��" + (i + 1) + "���鹲��" + attrs.getLength() + "������");
				// ����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item(int index)������ȡbook�ڵ��ĳһ������
					Node attr = attrs.item(j);
					// ��ȡ������
					System.out.print("������" + attr.getNodeName());
					// ��ȡ����ֵ
					System.out.println("---����ֵ" + attr.getNodeValue());

				}
				//ǰ�᣺֪��book�ڵ�����ֻ����1��id����
				//��book�ڵ����ǿ������ת����ת����Element����
//				Element book=(Element)booklist.item(i);
//				String attrValue=book.getAttribute("id");
//				System.out.println("id���Ե�����ֵΪ"+attrValue);
				
				//����book�ڵ���ӽڵ�
				NodeList childNodes=book.getChildNodes();
				//����childNode��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				System.out.println("��"+(i+1)+"���鹲��"+childNodes.getLength()+"���ӽڵ�");
				
			    //һ���оŸ��ֽڵ㣬����ÿ�����кͿհ���һ���ڵ�
				for(int k=0;k<childNodes.getLength();k++) {
					//System.out.println(childNodes.item(k).getNodeName());//#text�ǻ��кͿո���ɵ�
					//���ֳ�text���͵�node�Լ�element���͵�node
					if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE) {
						//��ȡ��element���ͽڵ�Ľڵ���
						System.out.print("��"+(k+1)+"���ڵ�Ľڵ���:"+childNodes.item(k).getNodeName());
						//��ȡ��element���ͽڵ�Ľڵ�ֵ
						//System.out.println("---�ڵ�ֵ�ǣ�"+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("---�ڵ�ֵ�ǣ�"+childNodes.item(k).getTextContent());
					
					}
				}
				System.out.println("============����������"+(i+1)+"���������============");
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
