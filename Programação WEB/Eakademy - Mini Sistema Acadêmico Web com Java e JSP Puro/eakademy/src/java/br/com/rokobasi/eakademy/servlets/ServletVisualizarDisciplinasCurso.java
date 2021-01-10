package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Disciplina_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visDisciplinaCurso")
public class ServletVisualizarDisciplinasCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if (param.equals("disciplinasDoCurso")) {
            
            int id_curso = Integer.valueOf(req.getParameter("id_curso"));

            DisciplinaDAO dao = new DisciplinaDAO();
            ArrayList<Disciplina_Curso> disciplinas_curso = (ArrayList<Disciplina_Curso>) dao.getDisciplinasDeCurso(id_curso);
            req.setAttribute("disciplinasDoCurso", disciplinas_curso);
            req.getRequestDispatcher("pages/coordenador/listaDeDisciplinas.jsp").forward(req, resp);

        } else {
            redirect(resp, "pages/coordenador/visualizarDisciplinasCurso", "Não foi possível visualizar as disciplinas!");
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
