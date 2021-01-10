package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.CursoDAO;
import br.com.rokobasi.eakademy.model.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editCurso")
public class ServletEditarCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Curso curso = null;
            CursoDAO dao = new CursoDAO();
            String nome = req.getParameter("nome");
            String area = req.getParameter("area");
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("editarCurso")) {

                Long id = Long.valueOf(req.getParameter("id"));
                curso = new Curso(id, nome, area);
                dao.updateCurso(curso);
                
                redirect(resp, "pages/diretor/listaDeCursos", "Curso editado com sucesso!");
                
            } else {
                redirect(resp, "pages/diretor/listaDeCursos", "Não foi possível editar o curso!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE EDITAR CURSO" + ex);
        }

    }
    
    public void redirect(HttpServletResponse resp, String pagina, String msg) throws IOException {

        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location='"+pagina+".jsp';");
        out.println("alert('"+msg+"');");
        out.println("</script>");

    }
    
}
