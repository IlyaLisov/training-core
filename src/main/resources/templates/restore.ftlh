<#ftl encoding="UTF-8">
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Restore password</title>
    <style>
        #body {
            display: flex;
            flex-direction: column;
            font-family: "Segoe UI", serif;
            align-items: center;
            background-color: #607FF2;
            font-size: 20px;
            height: 100%;
        }

        #div {
            display: block;
            flex-direction: column;
            margin: 10%;
            font-family: "Segoe UI", serif;
            background-color: white;
            padding: 3%;
            border-radius: 20px;
            color: black;
        }

        #button {
            background-color: #607FF2;
            border-radius: 10px;
            padding: 5px;
            color: white;
            text-decoration: none;
        }

        #a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="body">
    <div id="div">
        <h1 style="text-align: center">Restore password</h1>
        <p>You have requested password restore. Click on link below
            to continue. If it were not you, delete this message and change your
            password.</p>
        <p><a id="button" href="${link}">Restore</a></p>
        <i>Or visit this page if link does not work:<br> <a id="a"
                                                            href="${link}">${link}</a></i>
        <a id="a" href="${mainLink}">${mainDomainName}</a>
    </div>
</div>
</body>
</html>