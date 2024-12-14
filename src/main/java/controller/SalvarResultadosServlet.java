package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Matricula;
import model.Turma;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.MatriculaDAO;
import dao.TurmaDAO;

/**
 * Servlet implementation class SalvarResultadosServlet
 */
@WebServlet("/salvarResultados")
public class SalvarResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvarResultadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	        em.getTransaction().begin();

	        for (Matricula matricula : turma.getMatriculas()) {
	            String resultado = request.getParameter("resultado-" + matricula.getAluno().getMatricula());

	            if (resultado != null) {
	                matricula.setResultado(resultado);
	                matriculaDAO.atualizar(matricula); 
	            }
	        }

	        em.getTransaction().commit();
	        request.getSession().setAttribute("mensagem", "Resultados cadastrados com sucesso!");
	        response.sendRedirect("listarTurmasCadastrarResultados");
	    } catch (Exception e) {
	        em.getTransaction().rollback(); 
	        throw new ServletException("Erro ao salvar resultados", e);
	    } finally {
	        em.close();
	        emf.close();
	    }
	}

}


