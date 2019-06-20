app.service("woUserService",function($http){
	//显示用户名
	this.showName = function(){
		return $http.get('../user/showName.do');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('/user/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('/user/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('/user/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('/user/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('/user/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('/user/search.do?page='+page+"&rows="+rows, searchEntity);
	}
})