document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-cadastrar-turma");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const codigo = document.getElementById("codigo").value;
        const disciplina = document.getElementById("disciplina").value;

        if (!codigo || !disciplina) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        alert(`Turma cadastrada com sucesso!\nCódigo: ${codigo}\nDisciplina: ${disciplina}`);

        form.reset();
    });
});
