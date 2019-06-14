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
  app.controller("woRoleController",function($scope,$controller,$compile,woRoleService){
	
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
				 $scope.options.list = response.rows;
				 $scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		woRoleService.findOne(id).success(
			function(response){
				$scope.entity= response;					
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
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	//根据ids批量删除
	$scope.deleteByIds=function(){
		$scope.dele($scope.selectIds);
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
})