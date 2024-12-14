package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.Periodo;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DisciplinaDAO;
import dao.PeriodoDAO;

/**
 * Servlet implementation class ListarDisciplinasServlet
 */
@WebServlet("/listarDisciplinas")
public class ListarDisciplinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";
       
    /**	
     * @see HttpServlet#HttpServlet()
     */
    public ListarDisciplinasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
        PeriodoDAO periodoDAO = new PeriodoDAO(em);
        List<Disciplina> disciplinas = disciplinaDAO.listarTodos();	
        List<Periodo> periodos = periodoDAO.listarAtivos();
        em.close();
        emf.close();

        request.setAttribute("periodos", periodos);
        request.setAttribute("disciplinas", disciplinas);
        request.getRequestDispatcher("cadastrarTurma.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
