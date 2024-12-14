<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados da Turma</title>
    <link rel="stylesheet" href="css/verTurmasResultados.css">
</head>
<body>
    <header>
        <h1><a href="index.html">SIGAA</a></h1>
        <h2>Resultados da Turma: ${turma.numeroTurma} - ${turma.disciplina.nome}</h2>
    </header>

    <main>
        <h3>Alunos e Seus Resultados</h3>
        <table>
            <thead>
                <tr>
                    <th>Nome do Aluno</th>
                    <th>Matrícula</th>
                    <th>Resultado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="matricula" items="${matriculas}">
                    <tr>
                        <td>${matricula.aluno.nome}</td>
                        <td>${matricula.aluno.matricula}</td>
                        <td>${matricula.resultado != null ? matricula.resultado : "Não Definido"}</td>
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
