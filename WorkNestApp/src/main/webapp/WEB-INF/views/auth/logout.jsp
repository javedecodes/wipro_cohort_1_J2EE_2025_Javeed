<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // End the session
    if (session != null) {
        session.invalidate();
    }
    // Redirect back to login page
    response.sendRedirect("login.jsp");
%>
