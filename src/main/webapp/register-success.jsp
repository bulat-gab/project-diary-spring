<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Successful registration</title>
</head>
<body>
    <header><h1>Welcome to Diary Service, ${sessionScope.username}</h1></header>
    <form method="get" action="showdiaries">
        <input type="submit" value="Go to diaries">
    </form>
</body>
</html>