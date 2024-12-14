document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-cadastrar-resultados");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const checkboxes = form.querySelectorAll("input[type='checkbox']");
        const resultados = [];

        checkboxes.forEach((checkbox) => {
            const nome = checkbox.value;
            const aprovado = checkbox.checked;
            resultados.push({ nome, aprovado });
        });

        console.log("Resultados cadastrados:", resultados);
        alert("Resultados salvos com sucesso!");

        // Lógica adicional, como enviar os dados para o backend, pode ser adicionada aqui
    });
});
