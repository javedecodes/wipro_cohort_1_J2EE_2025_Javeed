<!DOCTYPE html>
<html>
<head>
    <title>Manage Users - WorkNest</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Manage Users</h2>

    <p><a href="<%=request.getContextPath()%>/admin/dashboard">Back to Dashboard</a></p>

    <h3>All Users</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
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
</div>
</body>
</html>
