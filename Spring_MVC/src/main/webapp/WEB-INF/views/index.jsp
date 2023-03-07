<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: osman
  Date: ৭/৩/২৩
  Time: ১২:৪০ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1> It's Coming Home</h1>
    <h2> called by home controller</h2>

<%--    <%--%>
<%--        String name = (String) request.getAttribute("name");--%>
<%--        List<String> skills = (List<String>) request.getAttribute("skills");--%>
<%--    %>--%>

<%--    <b> My Name is <%=name%> </b>--%>

<%--    <%--%>
<%--        for(String skill: skills) {--%>
<%--    %>--%>

<%--        <p>--%>
<%--            <%=skill%>--%>
<%--        </p>--%>

<%--    <%--%>
<%--        }--%>
<%--    %>--%>
    <h3>
        Hey ${user.username }, Your Email is ${user.email}.
        Unfortunately your password is: ${user.password}
    </h3>
</body>
</html>
