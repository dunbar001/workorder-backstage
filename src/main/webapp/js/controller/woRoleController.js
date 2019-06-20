/*app.directive('datatable', function () {
    return {
        restrict: 'E, A, C',
        link: function (scope, element, attrs, controller) {
            var dataTable = $(element[0]).dataTable(scope.options);
 
            scope.$watch('options.aaData', handleModelUpdates, true);
 
            function handleModelUpdates(newData) {
                var data = newData || null;
                if (data) {
                    dataTable.fnClearTable();
                    dataTable.fnAddData(data);
                    //=data.total;
                }
            }
        },
        scope: {
            options: "="
        }
    };
  })*/
  app.controller("woRoleController",function($scope,$controller,$compile,$sce,woRoleService){
	
	$controller("baseController",{$scope:$scope});
	
	/*$scope.options = {
		columns: [{
        	data:null,
        	"mRender": function (data, type, row, meta) {
                return '<input ng-checked="checked" ng-click="updateSelection($event,'+row.id+')" type="checkbox">';
            },
        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                $compile(nTd)($scope);
            }
        },{
            "data":"id",
            "render": function(data,type,row,meta){
            	if(data){
            		return data;
            	}else{
            		return "";
            	}
            }
        },{
            "data":"name",
            "render": function(data,type,row,meta){
            	if(data){
            		return data;
            	}else{
            		return "";
            	}
            }
        },{
            "data":"roleKey",
            "render": function(data,type,row,meta){
            	if(data){
            		return data;
            	}else{
            		return "";
            	}
            }
        },{
        	data:null,
        	"mRender": function (data, type, row, meta) {
                return '<a class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myEditModal" ng-click="findOne('+row.id+')" href="javascript:void(0)" >编辑</a> '+
                '<a class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myPermissModal" href="javascript:void(0)" >权限分配</a> ' + 
                '<a class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myDetailModal" ng-click="findOne('+row.id+')" href="javascript:void(0)">查看</a> ' +
                '<a class="btn btn-sm btn-primary" ng-click="deleteById('+row.id+')" href="javascript:void(0)">删除</a> ';
            },
        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                $compile(nTd)($scope);
            }
        }],
        columnDefs: [],
        bJQueryUI: true,
        bDestroy: true,
        "ordering": false,
        "searching": false,
        "dom": '<"top"i>rt<"bottom"flp><"clear">',
        aaData: [],
        "infoCallback": function( settings, start, end, max, total, pre ) {
	        return start +" to "+ end;
        }
    };*/
	
	//分页
	$scope.findPage=function(page,rows){	
		woRoleService.findPage(page,rows).success(
			function(response){
				 $scope.list = response.rows;
				 $scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		woRoleService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.allPermission = $sce.trustAsHtml($scope.ArraytoStr($scope.entity.permissionRole));
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=woRoleService.update( $scope.entity ); //修改  
		}else{
			serviceObject=woRoleService.add( $scope.entity  );//增加 
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
		woRoleService.dele(ids).success(
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
	$scope.deleteByIds=function(id){
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
		woRoleService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	$scope.checked=false;
	//全选/反选
	$scope.selectAll = function($event){
		$scope.checked=$event.target.checked;
		if($scope.checked){
			$scope.selectIds=[];
			$scope.list.forEach(function(item){
				$scope.selectIds.push(item.id);
			})
		}else{
			$scope.selectIds=[];
		}
	}
	
	//根据id删除
	$scope.deleteById=function(id){
		var arr = [id];
		$scope.dele($scope.selectIds);
	}
	
	//获取所有的权限数据
	$scope.findAllPermission=function(){
		woRoleService.findAllPermission().success(
				function(res){
					$scope.permissionList=res;
				}
		)
	}
	
	//权限的id集合
	$scope.permissionIds=[];
	//当前选择的用户组id
	$scope.currentRoleId="";
	
	//选择权限
	$scope.selectPermission = function($event, id) {		
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.permissionIds.push( id);			
		}else{
			var idx = $scope.permissionIds.indexOf(id);
            $scope.permissionIds.splice(idx, 1);//删除 
		}
	}
	//打开分配权限操作
	$scope.setRoleId=function(roleId){
		$scope.currentRoleId = roleId;
		$scope.permissionIds=[];
		//根据roleid查询已拥有权限
		woRoleService.findPermissionIdsByRid(roleId).success(
				function(response){
					$scope.permissionIds=response;
				}
		)
	}
	//是否选中
	$scope.isChecked=function(perId){
		for(var i=0;i<$scope.permissionIds.length;i++){
			if(perId == $scope.permissionIds[i]){
				return true;
			}
		}
		return false;
	}
	//保存分配的权限
	$scope.savePermission=function(){
		if($scope.currentRoleId === ""){
			alert("当前用户组不存在");
			return false;
		}
		if($scope.permissionIds.length === 0){
			alert("请选择权限");
			return false;
		}
		woRoleService.distributePermission($scope.currentRoleId,$scope.permissionIds).success(
				function(response){
					if(response.success){
						alert("分配成功");
						$("#myPermissModal").modal("hide");
					}else{
						alert("分配失败");
					}
				}
		)
	}
	
	$scope.ArraytoStr=function(arr){
		if(arr && arr.length > 0){
			var str="";
			for(var i=0;i<arr.length;i++){
				str+=arr[i].woPermission.parent.name + ":" + arr[i].woPermission.name +"<br>";
			}
			return str.substring(0, str.length-1);
		}
		return "";
	}
	
	//全选、反选
	$scope.selectAll=function(e,arr){
		if(e.target.checked){
			arr.forEach(function(item,i){
				if($scope.permissionIds.indexOf(item.id) == -1 ){
					$scope.permissionIds.push(item.id);
				}
			})
		}else{
			arr.forEach(function(item,i){
				$scope.permissionIds.splice($scope.permissionIds.indexOf(item.id),1);
			})
		}
	}
	
	$scope.isAllCheckedFunc=function(arr){
		if($scope.permissionIds.length === 0){
			return false;
		}else{
			for(var i=0;i<arr.length;i++){
				if($scope.permissionIds.indexOf(arr[i].id) == -1){
					return false;
				}
			}
		}
		return true;
	}
})