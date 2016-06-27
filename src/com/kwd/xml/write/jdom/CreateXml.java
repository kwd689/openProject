/*
 * 文 件 名:  CreateXml.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-7-22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.xml.write.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.LineSeparator;
import org.jdom2.output.XMLOutputter;

/**
 * <一句话功能简述>
 * 需要依赖jdom2-x-x.jar
 * 
 * @author  wendong.kang
 * @version  [MOCO V1.0, 2014-7-22]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CreateXml {
	/****
	 * 
	 * jdom生成xml
	 * @throws IOException
	 * @throws JDOMException
	 * @see [类、类#方法、类#成员]
	 */
	public void CreateXmlTest() throws IOException,JDOMException { 
        Element root,rootIn, element, text; 
        Document Doc; 
        // 创建一个根目录 
        root = new Element("employees_information"); 
        // 把这个根目录放入XML文件中 
        Doc = new Document(root); 
        // 得到文档中的根目录 
        root = Doc.getRootElement(); 
         
        // 创建一个name的子对象 
        element = new Element("姓名"); 
        // 设置他的值为\"C.Y. Shen\" 
        text = element.setText("陈浩");     
        // 设置name的一个属性emp_id并且给其赋值001 
        text = element.setAttribute("emp_id", "001");  
        // 用root将其加载到 
        element = root.addContent(text); 
        // 创建一个age的子对象 
        element = new Element("年龄"); 
        text = element.setText("43"); 
        element = root.addContent(text); 
        // 创建一个sex的子对象 
        element = new Element("性别"); 
        text = element.setText("Male");
        element = root.addContent(text); 
        for (int i = 0; i < 10; i++) {
        	element = new Element("子项目元素"+i); 
            text = element.setText("子项目元素内容"+i);
            element = root.addContent(text); 
		}
        // 创建XML输出的对象 
      
        XMLOutputter XMLOut = new XMLOutputter(); 
        //换行
        //XMLOut.setFormat(Format.getPrettyFormat());
        //不换行
       // XMLOut.setFormat(Format.getCompactFormat());
        XMLOut.setFormat(Format.getRawFormat());
  
        XMLOut.output(Doc, new FileOutputStream("d:"+File.separator+"test1.xml")); 
        System.out.println("Success ....."); 
    } 
    public static void main(String[] args){ 
        try{  
            CreateXml s1 = new CreateXml(); 
            System.out.println("Now we build an XML document ....."); 
            s1.CreateXmlTest1(); 
        }  
        catch (Exception e){  
           System.out.println(e.getMessage()); 
        } 
    } 
    public void CreateXmlTest1() throws IOException,JDOMException { 
        Element root,rootIn, element, text; 
        Document doc = new Document(); 
        // 创建一个根目录 
        root = new Element("employees_information"); 
        // 把这个根目录放入XML文件中 
        doc.setRootElement(root);
        
         
        // 创建一个学生对象 
        rootIn = new Element("Student"); 
        rootIn.setAttribute("emp_id", "001"); 
        // 创建一个name的子对象 
        element = new Element("name");
        element.setText("陈浩");
        rootIn.addContent(element); 
        // 创建一个age的子对象 
        element = new Element("年龄"); 
        element.setText("43"); 
        rootIn.addContent(element); 
        // 创建一个sex的子对象 
        element = new Element("性别"); 
        element.setText("Male");
        rootIn.addContent(element); 
      
        root.addContent(rootIn);
        
        for (int i = 0; i < 10; i++) {
        	// 创建一个学生对象 
            rootIn = new Element("Student"); 
            rootIn.setAttribute("emp_id", (i+1)+""); 
            // 创建一个name的子对象 
            element = new Element("name");
            element.setText("陈浩"+(i+1));
            rootIn.addContent(element); 
            // 创建一个age的子对象 
            element = new Element("年龄"); 
            element.setText(new Integer(i+12).toString()); 
            rootIn.addContent(element); 
            // 创建一个sex的子对象 
            element = new Element("性别"); 
            element.setText("Male");
            rootIn.addContent(element); 
            root.addContent(rootIn);
		}
        
        // 创建XML输出的对象 
      
        XMLOutputter XMLOut = new XMLOutputter(); 
        //换行
        XMLOut.setFormat(Format.getPrettyFormat());
        //不换行
       // XMLOut.setFormat(Format.getCompactFormat());
        //XMLOut.setFormat(Format.getRawFormat());
  
        XMLOut.output(doc, new FileOutputStream("d:"+File.separator+"test1.xml")); 
        System.out.println("Success ....."); 
    } 
}
