<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <title>Formulario </title>
    <style>
    body{
    font-family: 'Varela Round', sans-serif;
    background-color: #dfe4ea;
    display: flex;
    justify-content: center;
}

form{
    width: 25%;
    border:4px solid #3498db;
    margin: 20px;
    padding: 20px;
    border-radius: 10px;
}
h1{
    color:#3498db; 
}

label{
    font-size: 14px;
    display: block;
    width: 100%;
}

input{
    margin-bottom: 20px;
    width: 100%;
    padding: 10px;
    border:1px solid #eee;
    border-radius: 5px;
    box-sizing: border-box;
}

input:focus{
    border:1px solid #2980b9;
}

input[type="submit"] {
    margin-bottom: 0;
    background:#2980b9;
    color: #fff;
    border: none;
}

    </style>
</head>

<body>

    <form action="/formlogin" method="POST">
        <h1>Login</h1>
        <label for="username">Users:</label>
        <input id="username" type="text" name="usuario" />

        <label for="password">Password:</label>
        <input id="password" type="password" name="pass" />

        <label for="rememberMe">Remember</label>
        <input id="rememberMe" type="checkbox" name="rem" />

        <input type="submit" value="Enviar">
    </form>

</body>

</html>