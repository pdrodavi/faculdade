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

@WebServlet("/cadCurso")
public class ServletCadastroCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Curso curso = null;
            CursoDAO dao = new CursoDAO();
            String nome = req.getParameter("nome");
            String area = req.getParameter("area");
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("cadastrarCurso")) {

                curso = new Curso(nome, area);
                dao.cadastrarCurso(curso);
                
                redirect(resp, "pages/diretor/cadastrarCurso", "Curso cadastrado com sucesso!");

            }  else {
                redirect(resp, "pages/diretor/cadastrarCurso", "Não foi possível cadastrar o curso!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE CADASTRO DE CURSO" + ex);
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
