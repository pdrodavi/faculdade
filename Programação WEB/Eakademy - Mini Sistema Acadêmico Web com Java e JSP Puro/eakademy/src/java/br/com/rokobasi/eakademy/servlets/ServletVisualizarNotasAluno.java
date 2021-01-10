package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Notas_Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visNotasAlunoDisciplina")
public class ServletVisualizarNotasAluno extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // parametro recebido do input
        String param = req.getParameter("param");

        if(param.equalsIgnoreCase("visualizarNotas")){
            
            int id_disciplina = Integer.valueOf(req.getParameter("disciplina"));
            int id_aluno = Integer.valueOf(req.getParameter("id_aluno"));
            DisciplinaDAO dao = new DisciplinaDAO();
            ArrayList<Notas_Disciplina> notas_disciplina = (ArrayList<Notas_Disciplina>) dao.getNotasByDisciplina(id_disciplina, id_aluno);
            req.setAttribute("notasDaDisciplina", notas_disciplina);
            req.getRequestDispatcher("pages/aluno/notas.jsp").forward(req, resp);
            
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
