<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - WorkNest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container mt-5">
    <h2>Welcome, Admin!</h2>

    <div class="row mt-4">
        <div class="col-md-3">
            <a href="users.jsp" class="btn btn-outline-primary w-100">Manage Users</a>
        </div>
        <div class="col-md-3">
            <a href="tasks.jsp" class="btn btn-outline-success w-100">Manage Tasks</a>
        </div>
        <div class="col-md-3">
            <a href="comments.jsp" class="btn btn-outline-info w-100">View Comments</a>
        </div>
    </div>
</div>

</body>
</html>
