<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.util.Date" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String[] weekdays={"","日","一","二","三","四","五","六"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
    	days[i]="";

    Date currentDay = new Date();
    int year=1900+currentDay.getYear();
    int month=currentDay.getMonth();
    int today=currentDay.getDate();
    int weekday=currentDay.getDay()+1;
    
    String now=year+"年"+(month+1)+"月"+today+"日"+" 星期"+weekdays[weekday];
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>弹出无边框窗口背景变灰</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript">
        function showTime(showWhere){
            var now=new Date();
	        var hour=now.getHours();
	        var minu=now.getMinutes();
	        var sec=now.getSeconds();
         
            if(hour<10) hour="0"+hour;
         	if(minu<10) minu="0"+minu;
         	if(sec<10) sec="0"+sec;
         	
         	showWhere.value=hour+":"+minu+":"+sec;
            setTimeout("showTime(time)",1000)
        }
      </script>
<script language="javascript">
function Myopen(divID){ //根据传递的参数确定显示的层

     var notClickDiv=document.getElementById("notClickDiv");	//获取id为notClickDiv的层
     notClickDiv.style.width=document.body.clientWidth;		//设置宽度
     notClickDiv.style.height=document.body.clientHeight;	//设置高度
	 notClickDiv.style.display='block';			//设置层显示
     divID.style.left=(document.body.clientWidth-240)/2;	//设置由divID所指定的层的左边距
     divID.style.top=(document.body.clientHeight-139)/2;	//设置由divID所指定的层的顶边框
     divID.style.display='block';		//设置由divID所指定的层显示	 
}
function myClose(divID){
	divID.style.display='none';			//设置id为login的层隐藏
     //设置id为notClickDiv的层隐藏
	 document.getElementById("notClickDiv").style.display='none';	
}

</script>

</head>
<body onLoad="showTime(time)" bgcolor="#F0F0F0">
<div id="notClickDiv"></div>
<table width="800" height="45" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/indexT.jpg" width="800" height="115"></td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:1">
  <tr height="38">
    <td colspan="2" background="images/menu.jpg"><table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0">
        <tr height="50%" style="font-size:10pt">
          <td align="center"><%=now %>
            <input type="text" style="border:0;background-color:#F7F7F7" disable="true" id="time" size="9">
          </td>
          <td align="center" width="8%"><a href="#">首 页</a></td>
          <td align="center" width="8%"><a href="#" onClick="Myopen(login)">登 录</a></td>
          <td align="center" width="10%"><a href="#">我的帖子</a></td>
          <td align="center" width="10%"><a href="#">精华帖子</a></td>
          <td align="center" width="10%"><a href="#">进入后台</a></td>
          <td align="center" width="8%"><a href="#">注 册</a></td>
        </tr>
      </table></td>
  </tr>
  <tr height="40">
    <td width="529" align="center" background="images/indexP.jpg"><marquee 
			      onmouseover=this.stop()
				  onmouseout=this.start()				  
                  scrollamount="1"
				  scrolldelay="10"
				  direction="left"
				  width="470">
      <img src="images/pcard.gif"> 明日科技服务热线：(0431)8491*** E-mail：mingrisoft@mingrisoft.com
      </marquee>
    </td>
    <td align="center" width="271" background="images/messages.jpg"></td>
  </tr>
  <tr height="38">
    <td colspan="2" background="images/indexS.jpg" align="center"><table border="0" width="98%">
        <tr>
          <td width="25%"> 欢迎登录：游客，您还没有登录！ </td>
          <td align="right">
            请输入查询关键字：
              <input type="text" name="sqlvalue" size="30" value="">
            <input name="searchType" type="radio" class="noborder" value="like" checked="checked">
            模糊
            <input name="searchType" type="radio" class="noborder" value="all">
            精确
            <input type="submit" value=" " style="background-image:url('images/bs.jpg');width:49;height:21;border:0">
          </td></tr>
      </table></td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="800" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows" style="margin-top:8">
        <tr height="30">
          <td colspan="5" style="text-indent:5" background="images/classT.jpg"><b><font color="white">■ 精华帖子</font></b></td>
        </tr>
        <tr height="30" align="center" bgcolor="#F0F0F0">
          <td width="8%">状态</td>
          <td width="35%">帖子标题</td>
          <td width="7%">回复数</td>
          <td width="25%">发布者</td>
          <td width="25%">最后回复</td>
        </tr>
        <tr>
          <td colspan="5"><table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="all">
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">精华</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face3.gif"> <a href="#">JSP程序开发中有那些设计模式？..</a> </td>
                <td width="7%" align="center">0</td>
                <td width="25%" align="center"><a href="#"> <b>tsoft</b> <br>
                  2009-01-02 10:31:10 </a> </td>
                <td width="25%" align="center"><a href="#"> <b></b> <br>
                  </a> </td>
              </tr>
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">精华</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face11.gif"> <a href="#">乱码问题！！..</a> </td>
                <td width="7%" align="center">1</td>
                <td width="25%" align="center"><a href="#"> <b>tsoft</b> <br>
                  2009-01-01 08:33:52 </a> </td>
                <td width="25%" align="center"><a href="#"> <b>00</b> <br>
                  2009-01-07 13:06:34 </a> </td>
              </tr>
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">精华</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face3.gif"> <a href="#">开发JSP程序通常使用哪些框架？..</a> </td>
                <td width="7%" align="center">0</td>
                <td width="25%" align="center"><a href="#"> <b>wgh</b> <br>
                  2009-01-02 08:37:15 </a> </td>
                <td width="25%" align="center"><a href="#"> <b></b> <br>
                  </a> </td>
              </tr>
            </table></td>
        </tr>
        <tr height="10">
          <td colspan="5"></td>
        </tr>
        <tr height="30">
          <td colspan="6" background="images/boardE.jpg"></td>
        </tr>
    </table></td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/end.jpg" width="800" height="82"></td>
  </tr>
</table>
<!--登录窗口开始-->
<div id="login" style="position:absolute;width:260px; height:156px;display:none; z-index:10; background-image:url(images/login.jpg)">
<form name="form1" method="post" action="">
<table width="260" height="156" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="55">&nbsp;</td>
  </tr>
  <tr>
    <td align="center">用户名：<input type="text" name="username"></td>
  </tr>
  <tr>
    <td align="center">密&nbsp;&nbsp;码：<input type="password" name="pwd"></td>
  </tr>
  <tr>
    <td height="40" align="center"><input name="Submit" type="submit" class="btn_grey" value="登录">
      &nbsp;
        <input name="Submit2" type="button" class="btn_grey" value="关闭" onClick="myClose(login)"></td>
  </tr>
</table>
</form>
</div>
<!--登录窗口结束-->
</body>
</html>
