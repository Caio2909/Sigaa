package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Matricula;
import model.Turma;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.TurmaDAO;

/**
 * Servlet implementation class CadastrarResultadosServlet
 */
@WebServlet("/cadastrarResultados")
public class CadastrarResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";

    public CadastrarResultadosServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int turmaId = Integer.parseInt(request.getParameter("id"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        
        try {
        TurmaDAO turmaDAO = new TurmaDAO(em);
        Turma turma = turmaDAO.buscarPorId(turmaId);

        List<Matricula> matriculas = turma.getMatriculas();

        

        request.setAttribute("turma", turma);
        request.setAttribute("matriculas", matriculas);

        request.getRequestDispatcher("cadastrarResultados.jsp").forward(request, response);
        } finally {
			em.close();
			emf.close();
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
