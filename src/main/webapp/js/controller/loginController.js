app.controller("loginController",function($scope,$location){
	
	getUrlParam = function(name){
		//构造一个含有目标参数的正则表达式对象
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); 
	    if(window.location.search.length > 0){
	    	return "用户名或密码错误";
	    }else{
	    	return "";
	    }
	   /* //匹配目标参数
	    var r = window.location.search.substr(1).match(reg);
	    //返回参数值
	    if (r != null) return unescape(r[2]);
	    //不存在时返回null
	    return null; */
	}
	$scope.error = getUrlParam("error");
})