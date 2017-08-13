$(function() {
	// 请求后台服务
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
		var data = {
			userid : urlUserId,
		};
		//alert(JSON.stringify(data));
		// 请求后台保存数据
		$.post(DEGREEURL, data, function(result) {
			// 处理后台返回的结果
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				var hresult = [];
				var trStr = '';//动态拼接table
				if(jsonReturn.hasDegree=='yes'){
					 for(var i=0; i<jsonReturn.degreeRecords.length; i++){
		                    hresult[i]=jsonReturn.degreeRecords[i];
		                    //alert("姓名："+hresult[i]);
		                    trStr += '<tr class="example">';//拼接处规范的表格形式
		                    trStr += '<td align="center">' + hresult[i].degreeName + '</td>';//数据表的主键值
		                    trStr += '<td align="center">' + hresult[i].onDate + '</td>';//对应数组表的字段值
		                    trStr += '</tr>'; 
		                    $("#tbody").html(trStr);
		                } 
				}else{
					$("#mainTable").html("没有记录");
				}
				
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		},"json");
});