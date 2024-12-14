<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Aluno</title>
    <link rel="stylesheet" href="css/loginAluno.css">
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
        <h1><a href="#">SIGAA</a></h1>
        <h2>Login Aluno</h2>
    </header>
    <main>
        <form action="autenticarAluno" method="post" id="form-login-aluno">
            <div class="form-group">
                <label for="usuario">Nome de Usuário:</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div>
            <button type="submit">Entrar</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2024 SIGAA</p>
    </footer>
</body>
</html>
