package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.Periodo;
import model.Turma;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DisciplinaDAO;
import dao.PeriodoDAO;
import dao.TurmaDAO;

/**
 * Servlet implementation class CadastrarTurmaServlet
 */
@WebServlet("/cadastrarTurma")
public class CadastrarTurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarTurmaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroTurmaString = request.getParameter("codigo");
		String disciplinaCodigo = request.getParameter("disciplina");
		String peridoCodigo = request.getParameter("periodo");
		
		try {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();    
            TurmaDAO turmaDao = new TurmaDAO(em); 
            PeriodoDAO periodoDao = new PeriodoDAO(em);
            DisciplinaDAO disciplinaDao = new DisciplinaDAO(em);
            Periodo periodo = periodoDao.buscarPorId(Integer.parseInt(peridoCodigo));
            Disciplina disciplina = disciplinaDao.buscarPorId(Integer.parseInt(disciplinaCodigo));
            Turma turma = new Turma();
            turma.setNumeroTurma(numeroTurmaString);
            turma.setDisciplina(disciplina);
            turma.setPeriodo(periodo);
            turmaDao.salvar(turma);
            em.close();
            emf.close();

            response.sendRedirect("cadastrarTurma.jsp?mensagem=Turma+cadastrada+com+sucesso");
        } catch (Exception e) {
            response.sendRedirect("cadastrarTurma.jsp?mensagem=Erro+ao+cadastrar+Turma");
        
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
