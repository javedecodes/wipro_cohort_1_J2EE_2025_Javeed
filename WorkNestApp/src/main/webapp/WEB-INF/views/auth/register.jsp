<!DOCTYPE html>
<html>
<head>
    <title>Register - WorkNest</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form action="<%=request.getContextPath()%>/auth/register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required /><br/>
        <label>Email:</label>
        <input type="email" name="email" required /><br/>
        <label>Password:</label>
        <input type="password" name="password" required /><br/>
        <button type="submit">Register</button>
    </form>
    <p><a href="<%=request.getContextPath()%>/auth/login">Login</a></p>
    <% if(request.getAttribute("success") != null){ %>
        <p class="success"><%= request.getAttribute("success") %></p>
    <% } %>
</div>
</body>
</html>
