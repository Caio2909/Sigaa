document.addEventListener("DOMContentLoaded", () => {
    console.log("Página Ver Turmas e Resultados carregada.");
    
    // Você pode usar esse script para adicionar lógica, como buscar informações via API.
    // Exemplo: Exibir uma mensagem caso a tabela esteja vazia
    const tabela = document.querySelector("table tbody");

    if (tabela.children.length === 0) {
        const main = document.querySelector("main");
        const mensagem = document.createElement("p");
        mensagem.textContent = "Nenhuma turma encontrada.";
        mensagem.style.color = "#ff0000";
        main.appendChild(mensagem);
    }
});
