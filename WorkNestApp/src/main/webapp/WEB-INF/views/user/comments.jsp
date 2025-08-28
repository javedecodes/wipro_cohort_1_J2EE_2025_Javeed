<!DOCTYPE html>
<html>
<head>
    <title>User Comments</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
<h2>Your Comments</h2>
<p><a href="<%=request.getContextPath()%>/user/dashboard?userId=<%= request.getAttribute("userId") %>">Back to Dashboard</a></p>

<table>
<tr><th>ID</th><th>Task</th><th>Content</th><th>Created At</th></tr>
<%
    java.util.List comments = (java.util.List) request.getAttribute("comments");
    if(comments != null){
        for(Object o: comments){
            com.worknest.model.Comment c = (com.worknest.model.Comment)o;
%>
<tr>
    <td><%= c.getId() %></td>
    <td><%= c.getTask() != null ? c.getTask().getTitle() : "" %></td>
    <td><%= c.getContent() %></td>
    <td><%= c.getCreatedAt() %></td>
</tr>
<% } } %>
</table>
</body>
</html>
