<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>Cadastre-se</title>
    <link rel="shortcut icon" href="img/favicon.ico" />
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/shared.css">
    <link rel="stylesheet" href="css/cadastro.css">
</head>

<body>
    <main class="container main-container">
        <h1>Faça seu cadastro!</h1>
        <form action="CriaConta" method="POST">
            <input type="email" name="Email" placeholder="Email">
            <input type="text" name="Nome completo" placeholder="Nome completo">
            <input type="text" name="Nome de usuário" placeholder="Nome de usuário">
            <input type="password" name="Senha" placeholder="Senha">

            <h2>Escolha seu avatar:</h2>
            <div class="container avatares">  
                <input type="radio" name="radio" id="katara" value ="katara">
                <label for="katara" class="katara"></label>

                <input type="radio" name="radio" id="aang" value ="aang">
                <label for="aang" class="aang"></label>

                <input type="radio" name="radio" id="toph" value ="toph">
                <label for="toph" class="toph"></label>

                <input type="radio" name="radio" id="zuko" value ="zuko">
                <label for="zuko" class="zuko"></label>
            </div>
            <input type="submit" value="Confirmar" class="btn btn--small">
        </form>
    </main>
</body>

</html>