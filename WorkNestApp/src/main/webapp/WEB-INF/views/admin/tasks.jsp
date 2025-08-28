<!DOCTYPE html>
<html>
<head>
    <title>Manage Tasks - WorkNest</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Manage Tasks</h2>
    <p><a href="<%=request.getContextPath()%>/admin/dashboard">Back to Dashboard</a></p>

    <h3>All Tasks</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>User</th>
            <th>Status</th>
            <th>Start Date</th>
            <th>Due Date</th>
        </tr>
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
</div>
</body>
</html>
