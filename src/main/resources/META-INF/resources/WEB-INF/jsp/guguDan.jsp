<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <c:forEach var="i"  begin="1" end="9" step="1">
       ${list}X${i}=  <c:out value="${list*i}"/>

      <br />
    </c:forEach>


</body>
</html>
