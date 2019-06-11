app.controller("woUserController",function($scope,woUserService){
	$scope.getAllUser=function(){
		woUserService.getAllUser().success(
			function(response){
				$scope.list = response;
			}
		)
	}
	
	//获取当前登录用户名
	$scope.showName = function(){
		woUserService.showName().success(
				function(res){
					$scope.sysUser=res;
				}
		)
	}
})