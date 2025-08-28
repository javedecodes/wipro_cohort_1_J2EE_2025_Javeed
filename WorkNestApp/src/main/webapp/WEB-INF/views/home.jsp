<!DOCTYPE html>
<html>
<head>
    <title>Welcome - WorkNest App</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
    
</head>
<body>
<div class="welcome-container">
    <h1>Welcome to WorkNest App</h1>
    <p>Manage tasks efficiently, track progress, and collaborate with your team.</p>
    <a href="<%=request.getContextPath()%>/auth/login">Login</a>
    <a href="<%=request.getContextPath()%>/auth/register">Register</a>
</div>
</body>
</html>
