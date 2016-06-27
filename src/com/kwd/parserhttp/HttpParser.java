/*
 * 文 件 名:  HttpParser.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-9-16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.parserhttp;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;

/**
 * htmlparser解析html
 * thumbelina.jar,sitecapturer.jar,htmlparser.jar,htmllexer.jar,filterbuilder.jar
 * @author  wendong.kang
 */
public class HttpParser {

	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @throws ParserException 
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) throws ParserException {
		HttpParser pp = new HttpParser();  
	    pp.parser("http://www.baidu.com"); 

	}
	public NodeList parser(String url) throws ParserException{  
        /**根据url创建parser对象,   || Parser parser = Parser.createParser(url,encoding)**/  
        Parser parser =  new Parser(url);  
         
        /**设置编码，必须与url编码一样，否则挂掉 **/  
        parser.setEncoding("utf-8");  
         
        /** 构建一个html页面对象 **/  
        HtmlPage htmlPage = new HtmlPage(parser);  
        parser.visitAllNodesWith(htmlPage);  
         
        /** 获取body下面所有的节点 **/  
        NodeList list = htmlPage.getBody();  
         
        /** 建立一个filter，用于过滤节点 **/  
        NodeFilter filter = new TagNameFilter("A");  
         
        /** 得到过滤后的节点 **/  
        list = list.extractAllNodesThatMatch(filter, true);  
        
        for(int c =0; c < list.size(); c ++){  
                LinkTag linkTag = (LinkTag) list.elementAt(c);  
                System.out.println("["+linkTag.getStringText()+"]"+linkTag.getAttribute("href"));//取得href属性的值  
                //System.out.println(linkTag.getStringText());//取得链接的 文本  
        }  
        return list;  
    }  
}
