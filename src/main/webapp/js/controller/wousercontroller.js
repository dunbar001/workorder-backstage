app.controller("woUserController",function($scope,$controller,woUserService,woRoleService){
	
	$controller("baseController",{$scope:$scope});
	
	//获取当前登录用户名
	$scope.showName = function(){
		woUserService.showName().success(
				function(res){
					$scope.sysUser=res;
				}
		)
	}
	
	//分页
	$scope.findPage=function(page,rows){	
		woUserService.findPage(page,rows).success(
			function(response){
				 $scope.list = response.rows;
				 $scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		woUserService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=woUserService.update( $scope.entity ); //修改  
		}else{
			serviceObject=woUserService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					$('#myEditModal').modal('hide');
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	//批量删除 
	$scope.dele=function(ids){			
		//获取选中的复选框			
		woUserService.dele(ids).success(
			function(response){
				if(response.success){
					alert("删除成功");
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}else{
					alert("删除失败");
				}						
			}		
		);				
	}
	
	//根据ids批量删除
	$scope.deleteByIds=function(){
		$scope.dele($scope.selectIds);
	}
	//根据id删除
	$scope.deleteById=function(id){
		var arr = [];
		arr.push(id);
		$scope.dele(arr);
	}
	
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		woUserService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	$scope.genderList = [{text:"男",value:"男"},{text:"女",value:"女"}];
	
	$scope.findRoleSelect=function(){
		woRoleService.findRoleSelect().success(
				function(res){
					$scope.roleSelect = res;
				}
		)
	}
})