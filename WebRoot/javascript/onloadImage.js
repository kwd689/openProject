$(function(){
    var ei = $("#large");
    ei.hide();
    $("#img1, img").mousemove(function(e){
        ei.css({top:e.pageY,left:e.pageX}).html('<img style="border:1px solid gray;height: 172px;width: 172px;"  src="' + this.src + '" />').show();
    }).mouseout( function(){
        ei.hide();
    })
    $("#f1").change(function(){
    	var imageUrl = $("#f1").val();
    	if(isxls(imageUrl)){
    		 $("#img1").attr("src",$("#f1").val());
    	}
       
    })
});

function isxls(value) {
	var result = false;
	value=value.toLowerCase();
	if (value.endWith(".bmp") || value.endWith(".jpg") || value.endWith(".gif") || value.endWith(".png")) {
		result = true;
	}else{
		alert("文件格式不正确(兼容格式：bmp、jpg、gif和png)");
	}
	return result;
}