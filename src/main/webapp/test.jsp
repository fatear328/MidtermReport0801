<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="UploadForm" enctype="multipart/form-data" method="post"
    action="<%=request.getContextPath()%>/UploadFile">
<Input type="hidden" name="user_token" value="<%=request.getParameter("user_token") %>" />
<Input type="hidden" name="user" value="<%=request.getParameter("user") %>" />    
    CSV檔案<input type="file" name="Filecsv" size="50" maxlength="20" accept=".csv"/> 
<input type="submit" value="執行上傳"></form>



</body>
</html>