package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vincProfessorCurso")
public class ServletVincularProfessorAoCurso extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            UsuarioDAO dao = new UsuarioDAO();
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("vincularProfessorAoCurso")) {

                int professor = Integer.valueOf(req.getParameter("professor"));
                int curso = Integer.valueOf(req.getParameter("id_curso"));
                dao.vincularProfessorAoCurso(professor, curso);           
                redirect(resp, "coordenador/vincularProfessorAoCurso", "Professor vinculado com sucesso!");

            } else {
                redirect(resp, "coordenador/vincularDisciplinaAoProfessor", "Não foi possível realizar a operação");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE VINCULAR PROFESSOR AO CURSO" + ex);
        }

    }

    public void redirect(HttpServletResponse resp, String pagina, String msg) throws IOException {

        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location='"+pagina+".jsp';");
        out.println("alert('"+msg+"');");
        out.println("alert('Operação realizada com sucesso!');");
        out.println("</script>");

    }
    
}
