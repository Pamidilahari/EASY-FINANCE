<%@page import="utility.ServletUtility"%>
<body>
<%@ include file="header.jsp"%>
<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>
<h1>Welcome User</h1>
<%@ include file="footer.jsp"%>
</body>
</html>