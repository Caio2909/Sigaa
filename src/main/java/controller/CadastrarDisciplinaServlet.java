package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Disciplina;

import java.io.IOException;

import dao.DisciplinaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Servlet implementation class CadastrarDisciplinaServlet
 */
@WebServlet("/CadastrarDisciplina")
public class CadastrarDisciplinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        try {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            DisciplinaDAO dao = new DisciplinaDAO(em);

            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            dao.salvar(disciplina);

            em.close();
            emf.close();

            response.sendRedirect("cadastrarDisciplina.html?mensagem=Disciplina salva com sucesso!");
        } catch (NumberFormatException e) {
        	response.sendRedirect("cadastrarDisciplina.html?mensagem=Erro ao salvar Disciplina!");
    }
}
}
