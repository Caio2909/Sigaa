package controller;

import dao.MatriculaDAO;
import dao.TurmaDAO;
import model.Aluno;
import model.Matricula;
import model.Turma;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet("/realizarInscricao")
public class RealizarInscricaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String PERSISTENCE_UNIT_NAME = "Sigaa";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        HttpSession session = request.getSession();
        TurmaDAO turmaDAO = new TurmaDAO(em);
        MatriculaDAO matriculaDAO = new MatriculaDAO(em);

        try {
           
            int turmaId = Integer.parseInt(request.getParameter("turmaId"));
            Aluno aluno = (Aluno) session.getAttribute("aluno");
            Turma turma = turmaDAO.buscarPorId(turmaId);

            if (aluno != null && turma != null) {

                Matricula matricula = new Matricula(aluno, turma, "Pendente");
                matriculaDAO.salvar(matricula);

 
                response.sendRedirect("inscreverEmTurmas");
            } else {

                response.sendRedirect("inscreverEmTurmas.jsp?mensagem=Erro: Aluno ou Turma não encontrados.");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("inscreverEmTurmas.jsp?mensagem=Erro: Dados inválidos.");
        } finally {
            em.close();
            emf.close();
        }
    }
}
