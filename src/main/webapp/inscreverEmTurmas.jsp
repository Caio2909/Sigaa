<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscrever em Turmas</title>
    <link rel="stylesheet" href="css/inscreverEmTurmas.css">
</head>
<body>
	<script>
        window.onload = function() {
            const params = new URLSearchParams(window.location.search);
            const mensagem = params.get("mensagem");
            if (mensagem) {
                alert(mensagem);
            }
        }
    </script>
    <header>
        <h1><a href="indexAluno.jsp">SIGAA</a></h1>
        <h2>Inscrever em Turmas</h2>
    </header>
    <main>
        <h3>Turmas disponíveis para <c:out value="${aluno.nome}" />:</h3>
        <c:if test="${not empty turmasDisponiveis}">
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
                    <c:forEach var="turma" items="${turmasDisponiveis}">
                        <tr>
                            <td>${turma.codigo}</td>
                            <td>${turma.disciplina.nome}</td>
                            <td>${turma.periodo.ano} - ${turma.periodo.semestre}</td>
                            <td>${turma.numeroTurma}</td>
                            <td>
                                <a href="realizarInscricao?turmaId=${turma.codigo}">
                                    Inscrever-se
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty turmasDisponiveis}">
            <p>Nenhuma turma disponível para inscrição.</p>
        </c:if>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
</body>
</html>
