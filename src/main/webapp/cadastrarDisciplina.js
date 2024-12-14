document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-cadastrar-disciplina");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const nome = document.getElementById("nome").value;
        const codigo = document.getElementById("codigo").value;

        if (!nome || !codigo) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        alert(`Disciplina cadastrada com sucesso!\nNome: ${nome}\nCódigo: ${codigo}`);

        form.reset();
    });
});
