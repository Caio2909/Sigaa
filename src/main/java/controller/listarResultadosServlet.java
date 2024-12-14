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

import dao.MatriculaDAO;
import dao.TurmaDAO;

/**
 * Servlet implementation class listarResultadosServlet
 */
@WebServlet("/listarResultados")
public class listarResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarResultadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int turmaId = Integer.parseInt(request.getParameter("turmaId"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sigaa");
        EntityManager em = emf.createEntityManager();

        try {
            TurmaDAO turmaDAO = new TurmaDAO(em);
            MatriculaDAO matriculaDAO = new MatriculaDAO(em);

            Turma turma = turmaDAO.buscarPorId(turmaId);

            if (turma == null) {
                throw new ServletException("Turma não encontrada.");
            }

            List<Matricula> matriculas = matriculaDAO.listarPorTurma(turmaId);

            request.setAttribute("turma", turma);
            request.setAttribute("matriculas", matriculas);

            request.getRequestDispatcher("/verTurmaResultados.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao buscar resultados", e);
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
