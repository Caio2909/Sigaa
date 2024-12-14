package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Periodo;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PeriodoDAO;

/**
 * Servlet implementation class CadastrarPeriodoServlet
 */
@WebServlet("/cadastrarPeriodo")
public class CadastrarPeriodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPeriodoServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ano = request.getParameter("ano");
        String semestreStr = request.getParameter("semestre");
        String dataInicioStr = request.getParameter("dataInicio");
        String dataFimStr = request.getParameter("dataFim");

        try {
            int semestre = Integer.parseInt(semestreStr);
            Date dataInicio = Date.valueOf(dataInicioStr);
            Date dataFim = Date.valueOf(dataFimStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            PeriodoDAO dao = new PeriodoDAO(em);

            Periodo periodo = new Periodo(ano, semestre, dataInicio, dataFim);
            periodo.iniciarPeriodo();
            dao.salvar(periodo);

            em.close();
            emf.close();

            response.sendRedirect("cadastrarPeriodo.html?mensagem=Per%C3%ADodo+cadastrado+com+sucesso");
        } catch (Exception e) {
            response.sendRedirect("cadastrarPeriodo.html?mensagem=Erro+ao+cadastrar+o+per%C3%ADodo");
        }
    }

}
