app.service("woUserService",function($http){
	this.getAllUser=function(){
		return $http.get('../user/getAllUser.do');
	}
	
	this.showName = function(){
		return $http.get('../user/showName.do');
	}
})