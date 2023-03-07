<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: ৭/৩/২৩
  Time: ২:২৮ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About</title>
</head>
<body>
    <h1>This is XYZ from Home/About</h1>
    <%
        String content = (String) request.getAttribute("name");
    %>

    <i>
        This is all about Author: <%=content%>
    </i>
</body>
</html>
