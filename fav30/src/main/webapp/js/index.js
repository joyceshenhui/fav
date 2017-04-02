$("#listFavorites").panel({
	fit : true,
	title : " ",
	border : false,
});

$("#addFav").dialog({
	width:380,
	height:450,
	title:'',
	border:false,
	onOpen:function(){
		/*$(".panel").css("z-index","999");
		$(".window-shadow").css("z-index","998");*/
	}
});

$("#addFav").dialog("close", true);

$("#labels_table td").hover(selecrLabel);


loadTagInfo();

function loadTagInfo(){
	//以异步的方式取到所有书签的信息
	$.get("tag", function(data){
		//alert("请求响应成功！"+JSON.stringify(data));
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var tagTagetStr = "";
		for (var i = 0; i < data.length; i++) {
			tagTagetStr+='<tr><td><a href="javascript:void(0)" onclick="loadFavInfo(\'' + data[i].tname + '\')" >'+ 
			data[i].tname + '('+  data[i].tcount +')' + '</a></td></tr>';
		}
		//tagTagetStr += "<script type='text/javascript' src='js/index.js'></script>";
		$("#labelContent")[0].innerHTML = tagTagetStr;
		$("#labels_table td").hover(selecrLabel);
	}, "json");
}

function add(){
	
	$("#flabel").val("");
	$("#furl").val("");
	$("#ftags").val("");
	$("#fdesc").val("");
	UE.getEditor('fdesc');//<textarea>转成副文本编辑工具
	$("#addFav").dialog("open", true);
}

function addWinClose(){
	$("#addFav").dialog("close", true);
	return false;
}

function  selecrLabel(){
	$("#labels_table td").removeClass("selected_label");
	$(this).addClass("selected_label");
}

/*function addFavorite(){
	var jsonStr = toJsonStr($("#addFavForm").serialize());
	var str = $("#addFavForm").serialize();
	$.post("favorite/add",str, function(data){
	//$.post("favorite/add", function(data){
		//alert("请求响应成功！"+data);
		addWinClose();  //关闭添加书签窗口

		//添加书签结果信息
		$.messager.show({
			title:'添加书签信息',
			msg:'添加书签' + (data ? "成功..." : "失败!!!"),
			showType:'show',
			style:{
				top:document.body.scrollTop+document.documentElement.scrollTop,
			}
		});
		//重新加载书签信息
		loadFavInfo();

	}, "json");

	return false;
}
function toJsonStr(str){
	return str = "{\"" + str.replace(/=/g, "\":\"").replace(/&/g, "\",\"") + "\"}";
}*/
$("#addFavForm").form({
	url:"fav",
	success:function(data){
		addWinClose();  //关闭添加书签窗口

		//添加书签结果信息
		$.messager.show({
			title:'添加书签信息',
			msg:'添加书签' + (data ? "成功..." : "失败!!!"),
			showType:'show',
			style:{
				top:document.body.scrollTop+document.documentElement.scrollTop,
			}
		});
		//重新加载书签信息
		loadFavInfo();
	}
	
})
function addFavorite(){
	$("#addFavForm").submit();
	return false;
}


//显示所有的书签listFavorites

function loadFavInfo(tagName){
	//alert(JSON.stringify(tagName));
	$.get("fav/" + tagName,function(data){
		//alert(JSON.stringify(data));
		//$("#listFavorites").empty();
		var favStr="";
		for (var i = 0; i < data.length; i++) {
			/*$("#listFavorites").append("<div style='padding: 6px 10px;'><div>"+
							"<a href='"+data[i].furl+"' style='color: blue; font-size: 18px;' target='_blank'>"+data[i].flabel+"</a></div>"+
						"<div style='color: black; font-size: 16px;'>"+data[i].fdesc+"</div>"+
						"<div style='color: green; font-size: 14px;'>"+data[i].furl+"</div></div>");*/
			
			favStr += '<div style="padding: 6px 10px;">';
			favStr += '<div><a href="'+data[i].furl+'" style="color: blue; font-size: 18px;" target="_blank">'+data[i].flabel+'</a></div>';
			favStr += '<div style="color: black; font-size: 16px;">'+data[i].fdesc+'</div>';
			favStr += '<div style="color: green; font-size: 14px;">'+data[i].furl+'</div></div>';
		}
		$("#listFavorites").html(favStr);
	},"json");
}
loadFavInfo('-0');