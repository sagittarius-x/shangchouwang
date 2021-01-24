<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$.ajax({
				"url":"send/array.html",
				"type":"post",
				"data":{
					"array" : [5,8,10]
				},
				"dataTYpe":"Text",
				"success": function(reponse){
					
				},
				"error": function(response){
					
				}
			});
		});
	});
</script>
</head>
<body>
<a href="test/ssm.html">测试SSM</a>
<br/>

<button id="btn1">Send [5,8,10] One method</button>
</body>
</html>