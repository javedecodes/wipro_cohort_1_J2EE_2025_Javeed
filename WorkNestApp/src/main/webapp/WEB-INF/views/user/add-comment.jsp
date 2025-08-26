<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Comment - WorkNest</title>
</head>
<body>

<!-- Simple Navbar -->
<div style="background:#f0f0f0;padding:10px;">
    <a href="index.jsp">Home</a> | 
    <a href="tasks.jsp">Tasks</a> | 
    <a href="comments.jsp">Comments</a> | 
    <a href="users.jsp">Users</a> | 
    <a href="logout.jsp">Logout</a>
</div>
<hr/>

<h2>Add Comment to Task</h2>

<form action="addComment" method="post">
    <!-- Task ID hidden field -->
    <input type="hidden" name="taskId" value="<%= request.getParameter("taskId") %>"/>

    <label>Comment:</label><br/>
    <textarea name="content" rows="4" cols="50" required></textarea><br/><br/>

    <input type="submit" value="Submit"/>
</form>

</body>
</html>
