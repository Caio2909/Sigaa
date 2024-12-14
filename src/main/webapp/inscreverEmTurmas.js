document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-inscrever-turmas");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const checkboxes = form.querySelectorAll("input[type='checkbox']");
        const turmasSelecionadas = [];

        checkboxes.forEach((checkbox) => {
            if (checkbox.checked) {
                turmasSelecionadas.push(checkbox.value);
            }
        });

        if (turmasSelecionadas.length === 0) {
            alert("Nenhuma turma selecionada.");
            return;
        }

        const confirmacao = confirm(`Você selecionou as turmas: ${turmasSelecionadas.join(", ")}.\nDeseja confirmar a inscrição?`);

        if (confirmacao) {
            alert("Inscrição realizada com sucesso!");
            // Lógica adicional para salvar no backend pode ser implementada aqui.
        } else {
            alert("Inscrição cancelada.");
        }
    });
});
