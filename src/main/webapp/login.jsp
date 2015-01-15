<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>权限系统登录页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
<script type="text/javascript">



function reset(){
	$('#login_info_table :input').val("");
}
function submitForm(){
	var loginname = $('#loginname').val();
	var password =  $('#password').val();
	
	if(typeof loginname == 'undefined' || loginname == null || loginname == ''){
		$.messager.alert('提示','用户名不能为空');
		return false;
	}
	if(typeof password == 'undefined' || password == null || password == ''){
		$.messager.alert('提示','密码不能为空');
		return false;
	}
	
	return true;
}
</script>

</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height:100px;">系统标题</div>
	<div data-options="region:'south'" style="height:100px;">版权所有</div>
	<div data-options="region:'west',title:'公告栏'" style="width:200px;"></div>
	<div data-options="region:'center',title:'登录界面'" style="padding:5px;" align="center">
		<div style="height: 30%">
		
		</div>
		<form id="login_loginForm" method="post" action="${pageContext.request.contextPath}/loginAction/login.action">
			<table id="login_info_table">
				<tr>
					<td align="right">用户名</td>
					<td align="left"><input id="loginname" name="loginname" type="text" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;height: 30px;"/>
					</td>
				</tr>
				<tr>
					<td align="right">密码</td>
					<td align="left"><input id="password" name="password" type="password" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;;height: 30px;"/>
					</td>
				</tr>
				<tr>
			</table>
			<table>
					<td align="center"><input type="submit" value="登录" onclick="return submitForm()" style="width: 80px;;height: 35px;"/></td>
					<td align="center"><input type="button" value="清空" onclick="reset()" style="width: 80px;;height: 35px;"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
