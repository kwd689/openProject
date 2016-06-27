/*
 * 文 件 名:  HtmlParserTester.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-9-16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.parserhttp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.lexer.Page;
import org.htmlparser.tags.MetaTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wendong.kang
 * @version [MOCO V1.0, 2014-9-16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HtmlParserTester {

	/**
	 * <一句话功能简述> <功能详细描述>
	 * 
	 * @param args
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) {
		HtmlParserTester tester = new HtmlParserTester();
		//tester.parser();
		//tester.parserAll();
		tester.getHtmlCharset();
	}
    public void getHtmlCharset(){
    	try {
			Parser parser = new Parser(
					(HttpURLConnection) (new URL(
							"http://192.168.7.33:8080/StudyProject/weather/HtmlParserTester.html"))
							.openConnection());

			// 这里是控制测试的部分，后面的例子修改的就是这个地方。
			NodeFilter tagFilter = new TagNameFilter("meta");
			NodeFilter attrFilter = new HasAttributeFilter( "http-equiv");
			NodeFilter filter = new AndFilter(tagFilter, attrFilter);
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			if (nodes != null) {
				for (int i = 0; i < nodes.size(); i++) {
					Node textnode = (Node) nodes.elementAt(i);
					System.out.println("toHtml:" + textnode.toHtml());
					System.out.println("getText:" + textnode.getText());
					System.out.println("toString:" + textnode.toString());
					Page page = textnode.getPage();
					System.out.println("getPage:" + page.getEncoding());
					
					MetaTag metaTag= new MetaTag();
					metaTag.setText(textnode.toHtml());
					System.out.println("content:"+metaTag.getMetaContent());
					System.out.println("tagName:"+metaTag.getTagName());
					System.out.println("httpEquiv:"+metaTag.getHttpEquiv());
					if(metaTag.getHttpEquiv().toLowerCase().equals("content-type")){
						String content = metaTag.getMetaContent();
						System.out.println("*****************"+content);
						System.out.println("网页编码："+content.substring(content.indexOf("=")+1));
					}
					System.out.println("=================================================");
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	public void parser() {
		try {
			Parser parser = new Parser(
					(HttpURLConnection) (new URL(
							"http://192.168.7.33:8080/StudyProject/weather/HtmlParserTester.html"))
							.openConnection());

			// 这里是控制测试的部分，后面的例子修改的就是这个地方。
			NodeFilter filter = new TagNameFilter("DIV");
			NodeList nodes = parser.extractAllNodesThatMatch(filter);

			if (nodes != null) {
				for (int i = 0; i < nodes.size(); i++) {
					Node textnode = (Node) nodes.elementAt(i);
					System.out.println("getText:" + textnode.getText());
					System.out.println("=================================================");
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void parserAll(){
		try {
			Parser parser = new Parser(
					(HttpURLConnection) (new URL(
							"http://192.168.7.33:8080/StudyProject/weather/HtmlParserTester.html"))
							.openConnection());
			  for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
			      Node node = i.nextNode();
			      System.out.println("getText:"+node.getText());
			      System.out.println("getPlainText:"+node.toPlainTextString());
			      System.out.println("toHtml:"+node.toHtml());
			      System.out.println("toHtml(true):"+node.toHtml(true));
			      System.out.println("toHtml(false):"+node.toHtml(false));
			      System.out.println("toString:"+node.toString());
			      System.out.println("=================================================");
			  }
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}       
	}
}
