<!DOCTYPE html>
<html>
<head>
    <title>Login - WorkNest</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="<%=request.getContextPath()%>/auth/login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required /><br/>
        <label>Password:</label>
        <input type="password" name="password" required /><br/>
        <button type="submit">Login</button>
    </form>
    <p><a href="<%=request.getContextPath()%>/auth/register">Register</a></p>
    <% if(request.getAttribute("error") != null){ %>
        <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
</div>
</body>
</html>
