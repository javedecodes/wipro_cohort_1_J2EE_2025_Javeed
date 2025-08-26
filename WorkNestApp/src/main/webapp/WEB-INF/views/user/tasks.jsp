<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Tasks - WorkNest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<!-- Simple Navbar -->
<div class="bg-light p-2 mb-3 border-bottom">
    <a href="index.jsp" class="me-3">Home</a>
    <a href="user-dashboard.jsp" class="me-3">Dashboard</a>
    <a href="my-tasks.jsp" class="me-3">My Tasks</a>
    <a href="my-comments.jsp" class="me-3">My Comments</a>
    <a href="logout.jsp" class="text-danger">Logout</a>
</div>

<div class="container mt-4">
    <h2>My Tasks</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th><th>Title</th><th>Status</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Example row -->
        <tr>
            <td>101</td><td>Complete Documentation</td><td>IN_PROGRESS</td>
            <td>
                <a href="add-comment.jsp?taskId=101" class="btn btn-info btn-sm">Add Comment</a>
            </td>
        </tr>
        <!-- Later you’ll loop here with JSTL/Java -->
        </tbody>
    </table>
</div>

</body>
</html>
