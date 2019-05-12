app.service("wouserservice",function($http){
	this.getAllUser=function(){
		return $http.get('../user/getAllUser.do');
	}
})