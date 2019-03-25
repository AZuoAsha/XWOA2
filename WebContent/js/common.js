
window.onload = function(){  
    var userNameValue = getCookieValue("exampleInputEmail1");  
    document.getElementById("exampleInputEmail1").value = userNameValue;  
    var userPassValue = getCookieValue("exampleInputPassword1");  
    document.getElementById("exampleInputPassword1").value = userPassValue;  
}  
  
function userLogin(){   /**用户登录，其中需要判断是否选择记住密码**/  
    
    var objChk = document.getElementById("saveCookie");  
    if(objChk.checked==true){  
        //添加cookie  
        setCookie("exampleInputEmail1",document.getElementById("exampleInputEmail1").value,365,"/");  
        setCookie("exampleInputPassword1",document.getElementById("exampleInputPassword1").value,365,"/"); 
//        getCookie("exampleInputEmail1");
//        getCookie("exampleInputPassword1");
//        alert("记住了你的密码登录。");   
    }else{  
    	setCookie("exampleInputEmail1",document.getElementById("exampleInputEmail1").value,365,"/");
//    	deleteCookie("exampleInputEmail1","/");
    	deleteCookie("exampleInputPassword1","/");
//        alert("不记住密码登录。");  
    }  
}  