<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Turmas</title>
    <link rel="stylesheet" href="css/listarTurmas.css">
</head>
<body>
    <header>
        <h1><a href="index.html">SIGAA</a></h1>
        <h2>Listar Turmas de Períodos Ativos</h2>
    </header>
    <main>
        <h3>Turmas Ativas:</h3>
        <table>
            <thead>
                <tr>
                    <th>Código da Turma</th>
                    <th>Disciplina</th>
                    <th>Período</th>
                    <th>Número da Turma</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="turma" items="${turmas}">
                    <tr>
                        <td>${turma.codigo}</td>
                        <td>${turma.disciplina.nome}</td>
                        <td>${turma.periodo.ano}.${turma.periodo.semestre}</td>
                        <td>${turma.numeroTurma}</td>
                        <td>
                            <a href="cadastrarResultados?id=${turma.codigo}">Cadastrar Resultados</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
</body>
</html>
