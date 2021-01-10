package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.model.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadTurma")
public class ServletCadastrarTurma extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {     
            Turma turma = null;
            TurmaDAO dao = new TurmaDAO();
            long id_curso = Long.valueOf(req.getParameter("id_curso"));
            int periodo = Integer.valueOf(req.getParameter("periodo"));
            String sigla = req.getParameter("sigla");
            
            String type = req.getParameter("param");
            
            if (type.equalsIgnoreCase("cadastrarTurma")) {
                
                turma = new Turma(id_curso, periodo, sigla);
                dao.cadastrarTurma(turma);
                
                redirect(resp, "pages/coordenador/cadastrarTurma", "Turma cadastrada com sucesso!");

            } else {
                redirect(resp, "pages/coordenador/cadastrarTurma", "Não foi possível cadastrar a turma!");
            }
            
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERRO NO SERVLET DE CADASTRO DE TURMA" + ex);
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