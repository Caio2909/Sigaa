document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-cadastrar-periodo");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const ano = document.getElementById("ano").value;
        const semestre = document.getElementById("semestre").value;
        const dataInicio = document.getElementById("dataInicio").value;
        const dataFim = document.getElementById("dataFim").value;

        if (!ano || !semestre || !dataInicio || !dataFim) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        alert(`Período cadastrado com sucesso!\nAno: ${ano}\nSemestre: ${semestre}\nInício: ${dataInicio}\nFim: ${dataFim}`);

        form.reset();
    });
});
