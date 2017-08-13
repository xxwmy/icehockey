$(function() {
	// 请求后台服务
	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值
	var data = {
		userid : urlUserId,
	};
	// alert(JSON.stringify(data));
	// 请求后台保存数据
	$
			.post(
					TEACHTEAMURL,
					data,
					function(result) {
						// 处理后台返回的结果
						var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
						if (jsonReturn.result == "0") {
							var hresult = [];
							var trStr = '';// 动态拼接table
							if (jsonReturn.teamRecords.length != 0) {
								for (var i = 0; i < jsonReturn.teamRecords.length; i++) {
									hresult[i] = jsonReturn.teamRecords[i];
									// alert("姓名："+hresult[i]);
									trStr += '<tr class="example">';// 拼接处规范的表格形式
									trStr += '<td align="center">'
											+ hresult[i].teamName + '</td>';// 数据表的主键值
									trStr += '<td align="center">'
											+ hresult[i].inDate + '</td>';// 对应数组表的字段值
									trStr += '<td align="center">'
											+ hresult[i].outDate + '</td>';// 对应数组表的字段值
									trStr += '<td align="center">'
											+ hresult[i].score + '</td>';// 对应数组表的字段值
									trStr += '</tr>';
									$("#tbody").html(trStr);
								}
							} else {
								$("#mainTable").html("");
							}
							trStr = '';
							if (jsonReturn.clubRecords.length != 0) {
								for (var i = 0; i < jsonReturn.clubRecords.length; i++) {

									hresult[i] = jsonReturn.clubRecords[i];
									trStr += '<tr class="example">';// 拼接处规范的表格形式
									trStr += '<td align="center">'
											+ hresult[i].clubName + '</td>';// 数据表的主键值
									trStr += '<td align="center">'
											+ hresult[i].clubManager + '</td>';// 对应数组表的字段值
									trStr += '<td align="center">'
											+ hresult[i].address + '</td>';// 对应数组表的字段值
									trStr += '<td align="center">'
											+ hresult[i].inDate + '</td>';// 对应数组表的字段值
									trStr += '<td align="center">'
											+ hresult[i].outDate + '</td>';// 对应数组表的字段值
									trStr += '</tr>';
									$("#tbody1").html(trStr);
								}
							} else {
								$("#mainTable1").html(trStr);
							}
						} else if (jsonReturn.result == "-1") {
							alert("当前没有登录用户");
						}
					}, "json");
});