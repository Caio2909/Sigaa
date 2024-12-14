<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Turma</title>
    <link rel="stylesheet" href="css/cadastrarTurma.css">
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
        <h2>Cadastrar Turma</h2>
    </header>
    <main>
        <form id="form-cadastrar-turma" method="post" action="cadastrarTurma">
            <div class="form-group">
                <label for="codigo">Número da Turma:</label>
                <input type="text" id="codigo" name="codigo" placeholder="T-XX" required>
            </div>
            <div class="form-group">
                <label for="disciplina">Disciplina:</label>
                <select id="disciplina" name="disciplina" required>
                    <option value="">Selecione uma disciplina</option>
                    <c:forEach var="disciplina" items="${disciplinas}">
                        <option value="${disciplina.codigo}">${disciplina.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="periodo">Periodo:</label>
                <select id="periodo" name="periodo" required>
                    <option value="">Selecione um Periodo</option>
                    <c:forEach var="periodo" items="${periodos}">
                        <option value="${periodo.id}">${periodo.ano}.${periodo.semestre}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
</body>
</html>
