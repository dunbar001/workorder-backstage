app.controller("wousercontroller",function($scope,wouserservice){
	$scope.getAllUser=function(){
		wouserservice.getAllUser().success(
			function(response){
				$scope.list = response;
			}
		)
	}
})