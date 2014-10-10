<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Login Page</title>
</head>
<body><center>

   <h3>Welcome to Magento!</h3>
   <p>Please Login before doing any operations:</p>
   
   <form action="login/authenticator" method="post" >
      username: <input type="text" name="username" /><br>
      password: <input type="text" name="password" /><br>
      <br><br>
      <input type="submit" value="submit" />&nbsp;&nbsp;&nbsp;<input type="reset" value="reset" />
   
   </form>
</center></body>
</html>