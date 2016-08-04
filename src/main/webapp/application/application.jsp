<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>counter</title>
</head>
<body>
<%
     Object counter=application.getAttribute("counter");
if (counter==null){
	application.setAttribute("counter",new Integer(1));
	out.print("you are the first visitor");
}
	else{
      int  index=Integer.parseInt(application.getAttribute("counter").toString());	
      ++index;
      application.setAttribute("counter", index);
      out.print("you are the "+index+"th visitor");
}




%>
</body>
</html>