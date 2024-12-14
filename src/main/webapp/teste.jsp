<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Criar Aluno</title>
</head>
<body>
    <h1>Criar Aluno</h1>
    <form action="salvarAluno" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <br><br>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>