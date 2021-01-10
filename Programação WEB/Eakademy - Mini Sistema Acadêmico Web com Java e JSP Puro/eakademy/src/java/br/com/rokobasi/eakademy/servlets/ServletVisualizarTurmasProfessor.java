package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.model.Aluno_Turma;
import br.com.rokobasi.eakademy.model.Professor_Turma;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visTurmasProfessor")
public class ServletVisualizarTurmasProfessor extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if (param.equals("visualizarTurmasDoProfessor")) {

            int id_professor = Integer.valueOf(req.getParameter("id_professor"));

            TurmaDAO dao = new TurmaDAO();
            ArrayList<Professor_Turma> turmasProfessor = (ArrayList<Professor_Turma>) dao.getTurmasProfessorComID(id_professor);
            req.setAttribute("turmasDoProfessor", turmasProfessor);
            req.getRequestDispatcher("pages/professor/listaDeTurmas.jsp").forward(req, resp);
            //resp.sendRedirect("coordenador/index.jsp");

        } else if(param.equalsIgnoreCase("visualizarTurmasDoProfessorForAlunos")){

            int id_professor = Integer.valueOf(req.getParameter("id_professor"));
            
            TurmaDAO dao = new TurmaDAO();
            ArrayList<Professor_Turma> turmasProfessor = (ArrayList<Professor_Turma>) dao.getTurmasProfessorComID(id_professor);
            req.setAttribute("turmasDoProfessor", turmasProfessor);
            req.getRequestDispatcher("pages/professor/listaAlunosDaTurma.jsp").forward(req, resp);
        
        } else if(param.equalsIgnoreCase("visualizarAlunosDeTurmaProfessor")){
            
            int id_turma = Integer.valueOf(req.getParameter("turma"));
            TurmaDAO dao =  new TurmaDAO();
            ArrayList<Aluno_Turma> alunos_turma = (ArrayList<Aluno_Turma>) dao.getAlunosByTurma(id_turma);
            req.setAttribute("alunosDaTurma", alunos_turma);
            req.getRequestDispatcher("pages/professor/listaDeAlunosDaTurma.jsp").forward(req, resp);
        
        } else {
            redirect(resp, "professor/visualizarTurmas", "Não foi possível visualizar suas turmas!");
        }

    }

    public void redirect(HttpServletResponse resp, String pagina, String msg) throws IOException {

        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location='" + pagina + ".jsp';");
        out.println("alert('" + msg + "');");
        out.println("</script>");

    }
    
}
