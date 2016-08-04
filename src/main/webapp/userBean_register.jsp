<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="car" class="entity.Car"></jsp:useBean>
<jsp:setProperty property="name" name="car"/>
<jsp:setProperty property="price" name="car"/>

<jsp:getProperty property="name" name="car"/>
<jsp:getProperty property="price" name="car"/>
</body>
</html>