<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Admin Dashboard</h2>
    <%
        com.worknest.model.User currentUser = (com.worknest.model.User) session.getAttribute("currentUser");
    %>
    <p>Logged in as: <%= currentUser.getUsername() %> (Role: <%= currentUser.getRole() %>)</p>
    <p><a href="<%=request.getContextPath()%>/auth/logout">Logout</a></p>

    <h3>Users</h3>
    <table>
        <tr><th>ID</th><th>Username</th><th>Email</th><th>Role</th></tr>
        <%
            java.util.List users = (java.util.List) request.getAttribute("users");
            if(users != null){
                for(Object o: users){
                    com.worknest.model.User u = (com.worknest.model.User)o;
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getUsername() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getRole() %></td>
        </tr>
        <% } } %>
    </table>

    <h3>Add User</h3>
    <form action="<%=request.getContextPath()%>/admin/addUser" method="post">
        <label>Username:</label>
        <input type="text" name="username" required /><br/>
        <label>Email:</label>
        <input type="email" name="email" required /><br/>
        <label>Password:</label>
        <input type="password" name="password" required /><br/>
        <button type="submit">Add User</button>
    </form>

    <h3>Tasks</h3>
    <table>
        <tr><th>ID</th><th>Title</th><th>User</th><th>Status</th><th>Start</th><th>Due</th></tr>
        <%
            java.util.List tasks = (java.util.List) request.getAttribute("tasks");
            if(tasks != null){
                for(Object o: tasks){
                    com.worknest.model.Task t = (com.worknest.model.Task)o;
        %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getTitle() %></td>
            <td><%= t.getAssignedUser()!=null ? t.getAssignedUser().getUsername() : "" %></td>
            <td><%= t.getStatus() %></td>
            <td><%= t.getStartDate() %></td>
            <td><%= t.getDueDate() %></td>
        </tr>
        <% } } %>
    </table>

    <h3>Add Task</h3>
    <form action="<%=request.getContextPath()%>/admin/addTask" method="post">
        <label>Title:</label>
        <input type="text" name="title" required /><br/>
        <label>Description:</label>
        <textarea name="description"></textarea><br/>
        <label>User Email:</label>
        <input type="email" name="assignedUser.email" required /><br/>
        <label>Start Date:</label>
        <input type="date" name="startDate" required /><br/>
        <label>Due Date:</label>
        <input type="date" name="dueDate" required /><br/>
        <button type="submit">Add Task</button>
    </form>

    <p><a href="<%=request.getContextPath()%>/admin/comments">View Comments</a></p>
</div>
</body>
</html>
