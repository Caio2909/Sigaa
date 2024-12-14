<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Turmas e Resultados</title>
    <link rel="stylesheet" href="css/verTurmasResultados.css">
</head>
<body>
    <header>
        <h1><a href="indexAluno.jsp">SIGAA</a></h1>
        <h2>Ver Turmas e Resultados</h2>
    </header>
    <main>
        <h3>Turmas do Aluno</h3>
        <table>
            <thead>
                <tr>
                    <th>Período</th>
                    <th>Disciplina</th>
                    <th>Turma</th>
                    <th>Situação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="matricula" items="${matriculas}">
                    <tr>
                        <td>${matricula.turma.periodo.ano}.${matricula.turma.periodo.semestre}</td>
                        <td>${matricula.turma.disciplina.nome}</td>
                        <td>${matricula.turma.numeroTurma}</td>
                        <td>
                            <c:choose>
                                <c:when test="${matricula.resultado == 'Aprovado'}">Aprovado</c:when>
                                <c:when test="${matricula.resultado == 'Reprovado'}">Reprovado</c:when>
                                <c:otherwise>Cursando</c:otherwise>
                            </c:choose>
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
