<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <hr/>

  <form action="${pageContext.request.contextPath}/saveStudent" method="post">
    名称:<input type="text" name="name"> <br>
    邮箱:<input type="text" name="email"/> <br>
    学校: <input type="text" name="graduated_college"/> <br>
    学院代码:<input type="text" name="num"/> <br>
    <input type="submit" value="添加">
  </form>
  </body>
</html>
