<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>User Dashboard</h2>

    <%-- Display logged-in user info --%>
    <%
        com.worknest.model.User currentUser = (com.worknest.model.User) request.getAttribute("user");
        if(currentUser != null){
    %>
        <p>Logged in as: <%= currentUser.getUsername() %> (Role: <%= currentUser.getRole() %>)</p>
        <p><a href="<%=request.getContextPath()%>/auth/logout">Logout</a></p>
    <% } %>

    <h3>Your Tasks</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Status</th>
            <th>Start Date</th>
            <th>Due Date</th>
            <th>Update Status</th>
        </tr>

        <%-- Loop over tasks assigned to user --%>
        <%
            java.util.List tasks = (java.util.List) request.getAttribute("tasks");
            if(tasks != null){
                for(Object o : tasks){
                    com.worknest.model.Task t = (com.worknest.model.Task) o;
        %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getTitle() %></td>
            <td><%= t.getStatus() %></td>
            <td><%= t.getStartDate() %></td>
            <td><%= t.getDueDate() %></td>
            <td>
                <form action="<%=request.getContextPath()%>/user/updateStatus" method="post">
                    <input type="hidden" name="taskId" value="<%= t.getId() %>" />
                    <input type="hidden" name="userId" value="<%= currentUser.getId() %>" />
                    <select name="status">
                        <option value="IN_PROGRESS">In Progress</option>
                        <option value="COMPLETED">Completed</option>
                    </select>
                    <button type="submit">Update</button>
                </form>
            </td>
        </tr>
        <% } } %>
    </table>

    <h3>Add Comment</h3>
    <form action="<%=request.getContextPath()%>/user/addComment" method="post">
        <label>Task ID:</label>
        <input type="number" name="taskId" required /><br/>
        <label>Comment:</label>
        <textarea name="content" rows="3" cols="30" required></textarea><br/>
        <button type="submit">Add Comment</button>
    </form>
</div>
</body>
</html>
