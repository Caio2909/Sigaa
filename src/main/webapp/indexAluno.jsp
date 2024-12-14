<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:if test="${empty sessionScope.aluno}">
    <c:redirect url="loginAluno.jsp" />
</c:if>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGAA - Página Inicial</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <header>
        <h1><a href="indexAluno.html">SIGAA</a>
        </h1>
        <h2>Página Inicial</h2>
        <nav>
            <ul class="menu">              
                <li class="dropdown">
                    <a href="#">Aluno</a>
                    <ul class="dropdown-menu">
                        <li><a href="inscreverEmTurmas">Inscrever em turmas</a></li>
                        <li><a href="verTurmasResultados">Ver turmas/resultados</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    <main>
        <p>Bem-vindo ao SIGAA ${aluno.nome}! Selecione uma das opções acima para começar.</p>
        <div class="image-container">
            <img src="rural.png" alt="Imagem Rural" width="711" height="207">
        </div>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
    <script src="index.js"></script>
</body>
</html>
