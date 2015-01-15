<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String menuJson = (String)request.getAttribute("MenuJson");
if(menuJson == null){
	menuJson = "";
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>权限管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/json2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jslib/easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jslib/easyui/themes/color.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jslib/easyui/themes/icon.css"
	type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/commonUtil.js"></script>
	
<style>
.panelTextMiddle {
	text-align: center;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		var menuJson = '<%=menuJson%>';
		var mj = jQuery.parseJSON(menuJson);
		var menu_array;
		if (typeof menuJson != 'undefined' && mj != null && mj != '') {
			for(var i = 0;i<mj.length;i++){
				var treeId = mj[i].id + "tree";
				$('#index_Menu_accordion').accordion('add', {
					title : mj[i].text,
					content :'<ul id=\"'+treeId+'\"></ul>' ,
					selected : false
				});
				
				if(typeof mj[i].children != 'undefined' && mj[i].children != null && mj[i].children != ''){
					menu_array=new Array()
					for(var j = 0;j<mj[i].children.length;j++){
						menu_array[j] = mj[i].children[j];
					}
				   
				$("#" + treeId).tree({
								data : menu_array,
								onClick : function(node) {
									addTab(node)
								}
							});
						}
					}

				}
		  	$('#index_Main_tab').tabs('bindDblclick', function(index, title){
		  		if(index ==0 ){
		  			return;
		  		}
		        var vtab = $('#index_Main_tab').tabs('close',index);
		    });
		  	
			});
	
	function addTab(node){
		
		var vtab = $('#index_Main_tab');
		var vbody = $('#index_body');
		var vaccordion = $('#index_Menu_accordion');
		if(vtab.tabs('exists',node.text)){
			vtab.tabs('select',node.text);
			var accordion_title = vaccordion.accordion('getSelected').panel('options').title;
			vbody.layout('panel','center').setTitle(accordion_title+'>'+node.text);
		}else{
			vtab.tabs('add', {
				id:node.id,
				title : node.text,
				hrif  : ${pageContext.request.contextPath}+'/node.attributes.url',
				closable : true,
				tools : [ {
					iconCls : 'icon-mini-refresh',
					handler : function() {
						alert('refresh');
					}
				} ]
			});
			var accordion_title = vaccordion.accordion('getSelected').panel('options').title;
			vbody.layout('panel','center').panel('setTitle',accordion_title+'>'+node.text);
		}
		
	}
	function getAccPanel(title,index){
		var vtab = $('#index_Main_tab');
		var vbody = $('#index_body');
		var vaccordion = $('#index_Menu_accordion');
		vtab.tabs('select',0);
		var accordion_title = vaccordion.accordion('getSelected').panel('options').title;
		vbody.layout('panel','center').panel('setTitle',accordion_title);
	}
	
	
</script>

</head>

<body id="index_body" class="easyui-layout">
	<div data-options="region:'north'" style="height:100px;">系统标题</div>
	<div
		data-options="region:'west',title:'功能导航',split:false,collapsible:false"
		style="width:180px;">
		<div id="index_Menu_accordion" class="easyui-accordion"
			style="width:180px" data-options="fit:true,border:false,onSelect:function(title,index){ getAccPanel(title,index);}"></div>
	</div>
	<div data-options="region:'center',title:'首页 '"  align="center">
		<div id="index_Main_tab" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="首页" data-options="fit:true">
				首页
			</div>
		</div>
	
	</div>
	<div data-options="region:'south'" style="height:60px;">通知</div>
</body>
</html>
