app.controller("indexController",function($scope,indexService){
	
	//获取当前登录用户名
	$scope.showName = function(){
		indexService.showName().success(
				function(res){
					$scope.sysUser=res;
				}
		)
	}
})