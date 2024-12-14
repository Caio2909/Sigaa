package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Aluno;
import model.Matricula;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.MatriculaDAO;

/**
 * Servlet implementation class VerTurmasResultados
 */
@WebServlet("/verTurmasResultados")
public class VerTurmasResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PERSISTENCE_UNIT_NAME = "Sigaa";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
        	HttpSession session = request.getSession();
            Aluno aluno = (Aluno) session.getAttribute("aluno"); 
            if (aluno == null) {
                throw new ServletException("Aluno não encontrado.");
            }

            MatriculaDAO matriculaDAO = new MatriculaDAO(em);
            List<Matricula> matriculas = matriculaDAO.listarPorAluno(aluno);

            request.setAttribute("matriculas", matriculas);
            request.getRequestDispatcher("verTurmasResultados.jsp").forward(request, response);
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
