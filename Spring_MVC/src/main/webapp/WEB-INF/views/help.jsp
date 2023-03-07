<%@ page import="java.time.LocalDateTime" %>
<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: ৭/৩/২৩
  Time: ২:৪৬ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Help</title>
</head>
<body>
  <h1>Dynamic Value is render using ModelAndView</h1>

<%--  <%--%>
<%--    LocalDateTime localDateTime = (LocalDateTime) request.getAttribute("timestamp");--%>
<%--    String help = (String) request.getAttribute("help");--%>

<%--  %>--%>

<%--  <div>--%>
<%--    <i>--%>
<%--      <%=localDateTime%>--%>
<%--    </i>--%>
<%--    <p>--%>
<%--      <%=help%>--%>

<%--    </p>--%>
<%--  </div>--%>

  <div>
    <h4>Timestamp: ${timestamp} </h4>
    <footer>Help: ${help} </footer>
    <strong>
      ${branches}
    </strong>
  </div>
<%--  Not Worked JSTL --%>
<%--  <c:forEach var="item" items="branches">--%>
<%--    <c:out value="${item }"></c:out>--%>
<%--  </c:forEach>--%>
</body>
</html>
