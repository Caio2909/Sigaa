<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Turmas</title>
    <link rel="stylesheet" href="css/verTurmasResultados.css">
</head>
<body>
    <header>
        <h1><a href="index.html">SIGAA</a></h1>
        <h2>Ver Turmas e Resultados</h2>
    </header>
    <main>
        <table>
            <thead>
                <tr>
                    <th>Nome da Turma</th>
                    <th>Disciplina</th>
                    <th>Período</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="turma" items="${turmas}">
                    <tr>
                        <td>${turma.numeroTurma}</td>
                        <td>${turma.disciplina.nome}</td>
                        <td>${turma.periodo.ano }.${turma.periodo.semestre} </td>
                        <td>
                            <a href="listarResultadosAlunos?turmaId=${turma.codigo}">Ver Resultados</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>
