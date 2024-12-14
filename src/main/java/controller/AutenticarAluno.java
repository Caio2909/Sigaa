package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AlunoDAO;

/**
 * Servlet implementation class AutenticarAluno
 */
@WebServlet("/autenticarAluno")
public class AutenticarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = emf.createEntityManager();
	        
		AlunoDAO alunoDAO = new AlunoDAO(em);
		Aluno aluno = alunoDAO.buscarPorNomeESenha(usuario, senha);
		if (aluno != null) {
	        request.getSession().setAttribute("aluno", aluno);
	        response.sendRedirect("indexAluno.jsp");
	    } else {
	        response.sendRedirect("loginAluno.jsp?mensagem=Credenciais inválidas");
	    }
	}

}
