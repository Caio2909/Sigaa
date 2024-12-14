package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Aluno;
import model.Turma;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.TurmaDAO;

/**
 * Servlet implementation class InscreverEmTurmaServlet
 */
@WebServlet("/inscreverEmTurmas")
public class InscreverEmTurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        TurmaDAO turmaDAO = new TurmaDAO(em);

        try {
        	HttpSession session = request.getSession();
            Aluno aluno = (Aluno) session.getAttribute("aluno");

            if (aluno != null) {

            	List<Turma> turmasDisponiveis = turmaDAO.listarTurmasDisponiveisParaAluno(aluno);
                request.setAttribute("turmasDisponiveis", turmasDisponiveis);
                request.setAttribute("aluno", aluno);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID do aluno inválido.");
        } finally {
            em.close();
            emf.close();
        }

        request.getRequestDispatcher("inscreverEmTurmas.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
