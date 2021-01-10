package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.model.Professores_Turmas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visProfessoresTurmas")
public class ServletVisualizarProfessoresEturmas extends HttpServlet {
    
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("professoresEsuasTurmas")){
            
            int id_curso = Integer.valueOf(req.getParameter("id_curso"));
            TurmaDAO dao = new TurmaDAO();
            ArrayList<Professores_Turmas> turmas_professores = (ArrayList<Professores_Turmas>) dao.getTurmasProfessores(id_curso);
            req.setAttribute("professoresEsuasTurmas", turmas_professores);
            req.getRequestDispatcher("pages/coordenador/listaProfessoresEsuasTurmas.jsp").forward(req, resp);
        
        } else {
            redirect(resp, "pages/coordenador/index", "Não foi possível visualizar!");
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
