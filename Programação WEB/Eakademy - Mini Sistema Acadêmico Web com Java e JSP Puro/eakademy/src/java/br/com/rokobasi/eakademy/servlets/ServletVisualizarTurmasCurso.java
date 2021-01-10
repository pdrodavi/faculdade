package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.model.Turmas_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visTurmasCurso")
public class ServletVisualizarTurmasCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("turmasDoCurso")){
        
            int id_curso = Integer.valueOf(req.getParameter("id_curso"));
            TurmaDAO dao =  new TurmaDAO();
            ArrayList<Turmas_Curso> turmas_curso = (ArrayList<Turmas_Curso>) dao.getTurmasDeCurso(id_curso);
            req.setAttribute("turmasDoCurso", turmas_curso);
            req.getRequestDispatcher("pages/coordenador/listaDeTurmas.jsp").forward(req, resp);
            
        } else if(param.equalsIgnoreCase("turmasDoCursoAluno")){
            
            int id_curso = Integer.valueOf(req.getParameter("id_curso"));
            TurmaDAO dao =  new TurmaDAO();
            ArrayList<Turmas_Curso> turmas_curso = (ArrayList<Turmas_Curso>) dao.getTurmasDeCurso(id_curso);
            req.setAttribute("turmasDoCurso", turmas_curso);
            req.getRequestDispatcher("pages/coordenador/listaAlunoPorTurma.jsp").forward(req, resp);
        
        } else {
            redirect(resp, "pages/coordenador/index", "Não foi possível visualizar as disciplinas!");
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
