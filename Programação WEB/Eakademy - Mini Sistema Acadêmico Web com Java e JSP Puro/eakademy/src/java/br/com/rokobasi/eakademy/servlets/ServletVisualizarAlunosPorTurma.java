package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.model.Aluno_Turma;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visAlunosTurma")
public class ServletVisualizarAlunosPorTurma extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("visualizarAlunosDeTurma")){
        
            int id_curso = Integer.valueOf(req.getParameter("turma"));
            TurmaDAO dao =  new TurmaDAO();
            ArrayList<Aluno_Turma> alunos_turma = (ArrayList<Aluno_Turma>) dao.getAlunosByTurma(id_curso);
            req.setAttribute("alunosDaTurma", alunos_turma);
            req.getRequestDispatcher("pages/coordenador/listaDeAlunosDaTurma.jsp").forward(req, resp);
            
        } else {
            redirect(resp, "pages/coordenador/index", "Não foi possível visualizar os alunos!");
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
