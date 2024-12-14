document.addEventListener("DOMContentLoaded", () => {
    const btnConsolidar = document.getElementById("btn-consolidar");

    btnConsolidar.addEventListener("click", () => {
        const confirmacao = confirm("Tem certeza que deseja consolidar o período? Esta ação não poderá ser desfeita.");

        if (confirmacao) {
            alert("Período consolidado com sucesso!");
            // Lógica adicional, como enviar a confirmação ao backend, pode ser adicionada aqui.
        } else {
            alert("Ação cancelada.");
        }
    });
});
