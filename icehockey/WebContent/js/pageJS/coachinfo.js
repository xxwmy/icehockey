function mainClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/main.html?userid="+urlUserId;
}
function saichengClick(){
		var urlUserId = comm.getUrlParameter("userid");
	    window.location.href = "../../views/saicheng.html?userid="+urlUserId;
	

}

function gongjuClick(){
		var urlUserId = comm.getUrlParameter("userid");
		window.location.href = "../../views/gongjv.html?userid="+urlUserId;
}


function clubClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/imformation/mycommunity.html?userid="+urlUserId;	
}


function infoClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/imformation/oscenter.html?userid="+urlUserId;
}