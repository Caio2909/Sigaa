<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Resultados</title>
    <link rel="stylesheet" href="css/cadastrarResultados.css">
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
        <h1><a href="index.html">SIGAA</a></h1>
        <h2>Cadastrar Resultados para a Turma: ${turma.numeroTurma} - ${turma.disciplina.nome }</h2>
    </header>
    <main>
        <h3>Alunos da Turma</h3>
        <form action="salvarResultados" method="post">
            <input type="hidden" name="turmaId" value="${turma.codigo}">
            <table>
                <thead>
                    <tr>
                        <th>Nome do Aluno</th>
                        <th>Matricula</th>
                        <th>Aprovado</th>
                        <th>Reprovado</th>
                    </tr>
                </thead>
                <tbody>
                <c:if test="${not empty matriculas}">
                    <c:forEach var="matricula" items="${matriculas}">
                        <tr>
                            <td>${matricula.aluno.nome}</td>
                            <td>${matricula.aluno.matricula}</td>
                            <td>
                                <input type="radio" 
                                       name="resultado-${matricula.aluno.matricula}" 
                                       value="Aprovado" 
                                       id="aprovado-${matricula.aluno.matricula}">
                                <label for="aprovado-${matricula.aluno.matricula}">Aprovado</label>
                            </td>
                            <td>
                                <input type="radio" 
                                       name="resultado-${matricula.aluno.matricula}" 
                                       value="Reprovado" 
                                       id="reprovado-${matricula.aluno.matricula}">
                                <label for="reprovado-${matricula.aluno.matricula}">Reprovado</label>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <button type="submit">Salvar Resultados</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
</body>
</html>
