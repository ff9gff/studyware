<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String data = (String)request.getParameter("data"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>진행중인 스터디</h2>
<p>헤헿헿<%=data %></p>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	var member_no =  '<%= (String)request.getParameter("data") %>'
	
		getProgressList();
	
	function getProgressList(){
		var url = '/studyware/mypage/progress/all/'+member_no;
		console.log(url);
	}// end getProgressList()
</script>
</body>
</html>