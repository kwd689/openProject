<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*"%>
<jsp:useBean id="conn" scope="page" class="com.kwd.print.ConnDB"/>
<%
String sql="SELECT * FROM T_FACT_DATA T WHERE ROWNUM <=10 ORDER BY F_DATAID DESC";
ResultSet rs=conn.executeQuery(sql);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>��ӡ�����ϸ��</title>
<style>
@media print{
div{display:none}
}
</style>
<script language="javascript">
function deal(){
	var Expression=/^[1-9]+(\d*$)/;
	var objExp=new RegExp(Expression);
	if(objExp.test(form1.rsRow.value)==false){
		alert("�������ֵ����!");return false;
	}else{
		return true;
	}
}
function enter(){
	if(event.keyCode==13){
		var Expression=/^[1-9]+(\d*$)/;
		var objExp=new RegExp(Expression);
		if(objExp.test(form1.rsRow.value)==true){
			form1.submit()
		}
	}
}
</script>
<link href="CSS/printStyle.css" rel="stylesheet"/>
<body>
<table width="626"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="68" colspan="2" background="images/bg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td width="5%">&nbsp;</td>
    <td width="95%" align="left" valign="top">
	<table width="98%" border="1" cellpadding="0" cellspacing="0" bgcolor="#000000" id="pay" bordercolor="#00000" bordercolordark="#000000" bordercolorlight="#FFFFFF" style="border-bottom-style:none;">
	<thead style="display:table-header-group;font-weight:bold">
      <tr>
        <td width="75" height="27" align="center" bgcolor="#efefef">���ݱ��</td>
        <td width="140" align="center" bgcolor="#efefef">�ɼ��豸ID</td>
        <td width="103" align="center" bgcolor="#efefef">�ɼ�ʱ��</td>
        <td width="75" align="center" bgcolor="#efefef">������ֵ</td>
        <td width="75" align="center" bgcolor="#efefef">�ɼ�״̬</td>
        <td width="75" align="center" bgcolor="#efefef">��˾���</td>
        <td width="75" align="center" bgcolor="#efefef">������</td>
      </tr>
	</thead>
      <%
	int i=1;				//��Ʒ���
	int dataId;		//���ݱ��
	int termId;		//�ɼ��豸ID
	String time;//�ɼ�ʱ��
	double val;		//������ֵ
	String status;		//�ɼ�״̬
	int corpId;		//��˾���
	int rownum;		//������
	String rsRow=request.getParameter("rsRow");	//ÿҳ��ӡ������
	int intRsRow=5;	//Ĭ��ÿҳ��ӡ10��
	if(rsRow!=null && !rsRow.equals("")){
		intRsRow=Integer.parseInt(rsRow);
	}
	try{
	  while(rs.next()){
		  dataId=rs.getInt(1);
		  termId=rs.getInt(2);
		  time=rs.getString(3);
		  val=rs.getDouble(4);
		  status=rs.getString(5);
		  corpId=rs.getInt(6);
		 // rownum=rs.getBigDecimal(7).intValue();
	%>
	<%-- ie9 ����������ҳ chrome31  ��33 ������  --%>
	 <% if(i%intRsRow == 0){%> <tr style="page-break-after:always;" ><%}else{%>
     <tr><%} %>
	  <td height="25" align="center" bgcolor="#FFFFFF"><%=dataId%></td>
	  <td align="center" bgcolor="#FFFFFF">&nbsp;<%=termId%></td>
	   <td align="center" bgcolor="#FFFFFF">&nbsp;<%=time%></td>
	  <td align="center" bgcolor="#FFFFFF">&nbsp;<%=val%></td>
	  <td align="center" bgcolor="#FFFFFF">&nbsp;<%=status%></td>
	  <td align="center" bgcolor="#FFFFFF">&nbsp;<%=corpId%></td>
	  <td align="center" bgcolor="#FFFFFF">&nbsp;<%=i%></td>
	</tr>
	<%
		i++;
	}
  %>
  <tfoot style="display:table-footer-group; border:none;"><tr><td></td></tr></tfoot>
  </table>
<%
  }catch(Exception e){
    System.out.println(e.getMessage());
    e.printStackTrace();
  }
%>
<form name="form1" action="index.jsp" method="post" onSubmit="return deal()">
        <div align="center"><table width="95%" height="27" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="47%">ÿҳ��ӡ
                <input name="rsRow" type="text" value="<%=intRsRow%>" size="3" onKeyDown="enter()">
            ����¼
            </td>
            <td width="53%" align="right"><a href="#" onClick="window.print();">��ӡ</a></td>
          </tr>
    </table>
        </div>
	  </form>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
