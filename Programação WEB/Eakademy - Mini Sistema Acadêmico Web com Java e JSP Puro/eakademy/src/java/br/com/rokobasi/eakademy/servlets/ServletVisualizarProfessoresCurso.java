package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.CursoDAO;
import br.com.rokobasi.eakademy.model.Professor_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visProfessoresCurso")
public class ServletVisualizarProfessoresCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("professoresDoCurso")){
        
            int id_curso = Integer.valueOf(req.getParameter("id_curso"));
            CursoDAO dao = new CursoDAO();
            ArrayList<Professor_Curso> professores_curso = (ArrayList<Professor_Curso>) dao.getProfessoresDeCurso(id_curso);
            req.setAttribute("professoresDoCurso", professores_curso);
            req.getRequestDispatcher("pages/coordenador/listaDeProfessores.jsp").forward(req, resp);
        
        } else {
            redirect(resp, "pages/coordenador/index", "Não foi possível visualizar os professores!");
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
