<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Comments - WorkNest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container mt-5">
    <h2>Task Comments</h2>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Task</th>
            <th>User</th>
            <th>Comment</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Example hardcoded comments (you can replace with DB logic later)
            String[][] comments = {
                {"1", "Design UI", "Alice", "Looks good!", "2025-08-22"},
                {"2", "Implement Login", "Bob", "Need password encryption", "2025-08-22"},
                {"3", "Testing", "Charlie", "Found some bugs", "2025-08-21"}
            };

            for (String[] c : comments) {
        %>
        <tr>
            <td><%= c[0] %></td>
            <td><%= c[1] %></td>
            <td><%= c[2] %></td>
            <td><%= c[3] %></td>
            <td><%= c[4] %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
