package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Disciplinas_Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visDisciplinasAluno")
public class ServletVisualizarDisciplinasDoAluno extends HttpServlet {
    
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("visualizarDisciplinasDoAluno")){
            
            int id_aluno = Integer.valueOf(req.getParameter("id_aluno"));
            DisciplinaDAO dao = new DisciplinaDAO();
            ArrayList<Disciplinas_Aluno> disciplinas_aluno = (ArrayList<Disciplinas_Aluno>) dao.getDisciplinasDoAluno(id_aluno);
            req.setAttribute("disciplinasDoAluno", disciplinas_aluno);
            req.getRequestDispatcher("pages/aluno/disciplinasAluno.jsp").forward(req, resp);
            
        } else {
            redirect(resp, "pages/aluno/index", "Não foi possível visualizar!");
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
