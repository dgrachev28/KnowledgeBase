<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        form {
            margin: 0;
        }
        .loginForm {
            margin: 300px auto 0 auto;
            width: 300px;
            border-radius: 10px;
            border: solid 3px cadetblue;
            background: lightskyblue;
            padding: 10px;
        }
        .loginForm__row {
            padding: 10px;
        }
        .loginForm__row span {
            clear: right;
        }
        .loginForm__row input {
            width: 70%;
            float: right;
            background: #eeeeee;
        }
        .loginForm__submit {
            width: 50px;
            margin: auto;
            padding: 10px;
        }
        .loginForm__submit input {
            height: 26px;
            border-radius: 5px;
            width: 50px;
            background: lightgreen;
        }

    </style>
</head>
<body>
    <div class="loginForm">
        <form action="/" method="POST">
            <div class="loginForm__row"><span>Login: </span><input type="text" name="login"/></div>
            <div class="loginForm__row"><span>Password: </span><input type="password" name="password"/></div>
            <div class="loginForm__submit"><input type="submit" value="OK"/></div>
        </form>
    </div>
</body>
</html>
