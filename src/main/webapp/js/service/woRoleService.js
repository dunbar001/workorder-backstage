app.service("woRoleService",function($http){
	//分页 
	this.findPage=function(page,rows){
		return $http.get('/role/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('/role/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('/role/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('/role/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('/role/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('/role/search.do?page='+page+"&rows="+rows, searchEntity);
	}
})