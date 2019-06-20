app.service("indexService",function($http){
	//显示用户名
	this.showName = function(){
		return $http.get('../user/showName.do');
	}
})