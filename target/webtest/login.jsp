<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>servlet login</title>
</head>
<body>
<form  method="post" action="<%=request.getContextPath()%>/validate">
          user name:<input type="text" value="lemon" name="name"></input>
          password:<input type="password" value="123456" name="password"></input>
         <input type="submit" value="submit"></input>
</form>
</body>
</html>