<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Users - WorkNest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container mt-5">
    <h2>Users</h2>
    <a href="add-user.jsp" class="btn btn-primary mb-3">Add User</a>
    
    <table class="table table-bordered">
        <thead class="table-light">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Role</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Example static row -->
        <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>john@example.com</td>
            <td>ADMIN</td>
            <td>
                <a href="edit-user.jsp?id=1" class="btn btn-warning btn-sm">Edit</a>
                <a href="delete-user.jsp?id=1" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>Alice Smith</td>
            <td>alice@example.com</td>
            <td>USER</td>
            <td>
                <a href="edit-user.jsp?id=2" class="btn btn-warning btn-sm">Edit</a>
                <a href="delete-user.jsp?id=2" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
