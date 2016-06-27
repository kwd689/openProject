/*
 * 文 件 名:  DomParseXml.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-5-8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kwd.xml.entity.Student;

/**
 * <document解析xml文件>
 * <功能详细描述>
 * 
 * @author  wendong.kang
 * @version  [2014-5-8]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DomParseXml {
	 public List<Student> getStudent(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException{
		 DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 Document document = builder.parse(inputStream);
		 Element element = document.getDocumentElement();
		 NodeList nodeList = element.getElementsByTagName("student");
		 List<Student> list = new ArrayList<Student>();
		 for (int i = 0; i < nodeList.getLength(); i++) {
			Element studentElement = (Element) nodeList.item(i);
			Student student = new Student();
			student.setId(Integer.valueOf(studentElement.getAttribute("id")));
			student.setGroup(Integer.valueOf(studentElement.getAttribute("group")));
			NodeList studentNode  = studentElement.getChildNodes();
			for (int j = 0; j < studentNode.getLength(); j++) {
				if(studentNode.item(j).getNodeType()== Node.ELEMENT_NODE){
					if("name".equals(studentNode.item(j).getNodeName())){
						student.setName(studentNode.item(j).getFirstChild().getNodeValue());
					}else if("sex".equals(studentNode.item(j).getNodeName())){
						student.setSex(studentNode.item(j).getFirstChild().getNodeValue());
					}else if("age".equals(studentNode.item(j).getNodeName())){
						student.setAge(Integer.valueOf(studentNode.item(j).getFirstChild().getNodeValue()));
					}else if("email".equals(studentNode.item(j).getNodeName())){
						student.setEmail(studentNode.item(j).getFirstChild().getNodeValue());
					}else if("birthday".equals(studentNode.item(j).getNodeName())){
						student.setBirthday(studentNode.item(j).getFirstChild().getNodeValue());
					}else if("memo".equals(studentNode.item(j).getNodeName())){
						student.setMemo(studentNode.item(j).getFirstChild().getNodeValue());
					}
				}
			}//j for end
			list.add(student);
		}
		return list;
	 }

	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/kwd/xml/Student.xml");
		DomParseXml domParseXml = new DomParseXml();
		List<Student> list=domParseXml.getStudent(inputStream);
		for(Student student:list){
			System.out.println("id:"+student.getId()+"\tgroup:"+student.getGroup()+"\tname:"+student.getName()+"\tsex:"+student.getSex()+"\tage:"+student.getAge()+"\temail:"+student.getEmail()+"\tbirthday:"+student.getBirthday()+"\tmemo:"+student.getMemo());
		}
	}
}
