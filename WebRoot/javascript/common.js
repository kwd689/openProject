//js获取项目根路径
function getRootPath(){
    //获取当前网址
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
/*****
 * 取消网页默认按键设置
 * @return
 */
function deleDefault(){
	if(window.addEventListener) {
			document.addEventListener("keydown", function(e) {
			     var keyCode ;
			     if(e.keyCode) {
			    	 keyCode=e.keyCode;
			     }else if(e.which){
			    	 keyCode = e.which;
			     }
			     if (keyCode >= 37 && keyCode <= 40) {
			         e.preventDefault();
			     }
			});
	}else if (window.attachEvent) {
		   document.attachEvent("onkeydown", function(e) {
			     var keyCode;
			     if(e.keyCode) {
			    	 keyCode=e.keyCode;
			     }else if(e.which){
			    	 keyCode = e.which;
			     }
			     if (keyCode >= 37 && keyCode <= 40) {
			         e.returnValue = false;
			     }
		  });
   }
}
/*****
 * 增加endWith方法
 * @param s
 * @return
 */
String.prototype.endWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	     return false;
	  if(this.substring(this.length-s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
}
/****
 * 增加startWith方法
 * @param s
 * @return
 */
String.prototype.startWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	   return false;
	  if(this.substr(0,s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
}
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }
 String.prototype.ltrim=function(){
    return this.replace(/(^\s*)/g,"");
 }
 String.prototype.rtrim=function(){
    return this.replace(/(\s*$)/g,"");
 }
function getCPathHost(){
	return "http://192.168.5.25:9090";
}
function getRefresh(divId){
	$("#"+divId).html(' <center>正在努力加载···<img src="'+getRootPath()+'/images/pic/jiazai.gif"  /></center>');
}
function getNORefresh(divId){
	$("#"+divId).html('');
}
/*****
 * 获取系统当前时间（yyyy-MM-dd）
 * @return
 */
function getDateStr(){
	var myDate = new Date();
	var year=myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var month=parseInt(myDate.getMonth(),10)+1;       //获取当前月份(0-11,0代表1月)
	var day=myDate.getDate();        //获取当前日(1-31)
	if(month < 10){
		month = '0'+month;
	}
	if(day < 10){
		day = '0'+day;
	}
	return year+'-'+month+'-'+day;
}
/*****
 * utf-8 编码字符串字节数
 * @param str
 * @return
 */
function codeSizeof(str){
    var total = 0,
        charCode,
        i,
        len;
        for(i = 0, len = str.length; i < len; i++){
            charCode = str.charCodeAt(i);
            if(charCode <= 0x007f) {
                total += 1;
            }else if(charCode <= 0x07ff){
                total += 2;
            }else if(charCode <= 0xffff){
                total += 3;
            }else{
                total += 4;
            }
        }
    return total;
}
function myClose(){
	showDivid.style.display='none';
	document.getElementById("notClickDiv").style.display='none';
}
function myOpen(){
	var notObj=document.getElementById("notClickDiv");
	var notw = document.body.scrollWidth;
	var noth = document.body.scrollHeight;
	
	notObj.style.width = notw + "px";
	notObj.style.height = noth + "px";
	notObj.style.display='block';
	var showObj=document.getElementById("showDivid");
	var w = (document.body.clientWidth-300)/2;
	var h = (document.body.clientHeight-250)/2;
	showDivid.style.left = w + "px";
	showDivid.style.top = h + "px";
	showDivid.style.display='block';
}