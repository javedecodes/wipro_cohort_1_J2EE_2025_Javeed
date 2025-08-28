<!DOCTYPE html>
<html>
<head>
    <title>View Comments - WorkNest</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>All Comments</h2>
    <p><a href="<%=request.getContextPath()%>/admin/dashboard">Back to Dashboard</a></p>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Task</th>
            <th>User</th>
            <th>Comment</th>
            <th>Created At</th>
        </tr>
        <%
            java.util.List comments = (java.util.List) request.getAttribute("comments");
            if(comments != null){
                for(Object o: comments){
                    com.worknest.model.Comment c = (com.worknest.model.Comment)o;
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getTask()!=null ? c.getTask().getTitle() : "" %></td>
            <td><%= c.getUser()!=null ? c.getUser().getUsername() : "" %></td>
            <td><%= c.getContent() %></td>
            <td><%= c.getCreatedAt() %></td>
        </tr>
        <% } } %>
    </table>
</div>
</body>
</html>
