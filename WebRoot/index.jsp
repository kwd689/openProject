<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.util.Date" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String[] weekdays={"","��","һ","��","��","��","��","��"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
    	days[i]="";

    Date currentDay = new Date();
    int year=1900+currentDay.getYear();
    int month=currentDay.getMonth();
    int today=currentDay.getDate();
    int weekday=currentDay.getDay()+1;
    
    String now=year+"��"+(month+1)+"��"+today+"��"+" ����"+weekdays[weekday];
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>�����ޱ߿򴰿ڱ������</title>
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
function Myopen(divID){ //���ݴ��ݵĲ���ȷ����ʾ�Ĳ�

     var notClickDiv=document.getElementById("notClickDiv");	//��ȡidΪnotClickDiv�Ĳ�
     notClickDiv.style.width=document.body.clientWidth;		//���ÿ��
     notClickDiv.style.height=document.body.clientHeight;	//���ø߶�
	 notClickDiv.style.display='block';			//���ò���ʾ
     divID.style.left=(document.body.clientWidth-240)/2;	//������divID��ָ���Ĳ����߾�
     divID.style.top=(document.body.clientHeight-139)/2;	//������divID��ָ���Ĳ�Ķ��߿�
     divID.style.display='block';		//������divID��ָ���Ĳ���ʾ	 
}
function myClose(divID){
	divID.style.display='none';			//����idΪlogin�Ĳ�����
     //����idΪnotClickDiv�Ĳ�����
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
          <td align="center" width="8%"><a href="#">�� ҳ</a></td>
          <td align="center" width="8%"><a href="#" onClick="Myopen(login)">�� ¼</a></td>
          <td align="center" width="10%"><a href="#">�ҵ�����</a></td>
          <td align="center" width="10%"><a href="#">��������</a></td>
          <td align="center" width="10%"><a href="#">�����̨</a></td>
          <td align="center" width="8%"><a href="#">ע ��</a></td>
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
      <img src="images/pcard.gif"> ���տƼ��������ߣ�(0431)8491*** E-mail��mingrisoft@mingrisoft.com
      </marquee>
    </td>
    <td align="center" width="271" background="images/messages.jpg"></td>
  </tr>
  <tr height="38">
    <td colspan="2" background="images/indexS.jpg" align="center"><table border="0" width="98%">
        <tr>
          <td width="25%"> ��ӭ��¼���οͣ�����û�е�¼�� </td>
          <td align="right">
            �������ѯ�ؼ��֣�
              <input type="text" name="sqlvalue" size="30" value="">
            <input name="searchType" type="radio" class="noborder" value="like" checked="checked">
            ģ��
            <input name="searchType" type="radio" class="noborder" value="all">
            ��ȷ
            <input type="submit" value=" " style="background-image:url('images/bs.jpg');width:49;height:21;border:0">
          </td></tr>
      </table></td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="800" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows" style="margin-top:8">
        <tr height="30">
          <td colspan="5" style="text-indent:5" background="images/classT.jpg"><b><font color="white">�� ��������</font></b></td>
        </tr>
        <tr height="30" align="center" bgcolor="#F0F0F0">
          <td width="8%">״̬</td>
          <td width="35%">���ӱ���</td>
          <td width="7%">�ظ���</td>
          <td width="25%">������</td>
          <td width="25%">���ظ�</td>
        </tr>
        <tr>
          <td colspan="5"><table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="all">
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">����</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face3.gif"> <a href="#">JSP���򿪷�������Щ���ģʽ��..</a> </td>
                <td width="7%" align="center">0</td>
                <td width="25%" align="center"><a href="#"> <b>tsoft</b> <br>
                  2009-01-02 10:31:10 </a> </td>
                <td width="25%" align="center"><a href="#"> <b></b> <br>
                  </a> </td>
              </tr>
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">����</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face11.gif"> <a href="#">�������⣡��..</a> </td>
                <td width="7%" align="center">1</td>
                <td width="25%" align="center"><a href="#"> <b>tsoft</b> <br>
                  2009-01-01 08:33:52 </a> </td>
                <td width="25%" align="center"><a href="#"> <b>00</b> <br>
                  2009-01-07 13:06:34 </a> </td>
              </tr>
              <tr height="35" bgcolor="#F9F9F9">
                <td width="8%" align="center">����</td>
                <td width="35%" style="text-indent:10"><img src="images/bbs/face3.gif"> <a href="#">����JSP����ͨ��ʹ����Щ��ܣ�..</a> </td>
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
<!--��¼���ڿ�ʼ-->
<div id="login" style="position:absolute;width:260px; height:156px;display:none; z-index:10; background-image:url(images/login.jpg)">
<form name="form1" method="post" action="">
<table width="260" height="156" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="55">&nbsp;</td>
  </tr>
  <tr>
    <td align="center">�û�����<input type="text" name="username"></td>
  </tr>
  <tr>
    <td align="center">��&nbsp;&nbsp;�룺<input type="password" name="pwd"></td>
  </tr>
  <tr>
    <td height="40" align="center"><input name="Submit" type="submit" class="btn_grey" value="��¼">
      &nbsp;
        <input name="Submit2" type="button" class="btn_grey" value="�ر�" onClick="myClose(login)"></td>
  </tr>
</table>
</form>
</div>
<!--��¼���ڽ���-->
</body>
</html>
