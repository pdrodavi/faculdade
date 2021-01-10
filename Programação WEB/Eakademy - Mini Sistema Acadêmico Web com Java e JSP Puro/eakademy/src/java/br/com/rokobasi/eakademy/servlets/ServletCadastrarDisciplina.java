package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadDisciplina")
public class ServletCadastrarDisciplina extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Disciplina disciplina = null;
            DisciplinaDAO dao = new DisciplinaDAO();
            String nome = req.getParameter("nome");
            long id_curso = Integer.valueOf(req.getParameter("id_curso"));
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("cadastrarDisciplina")) {

                disciplina = new Disciplina(id_curso, nome);
                dao.cadastrarDisciplina(disciplina);
                
                redirect(resp, "pages/coordenador/cadastrarDisciplina", "Disciplina cadastrada com sucesso!");
                
            }  else {
                redirect(resp, "pages/coordenador/cadastrarDisciplina", "Não foi possível cadastrar a disciplina!");
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERRO NO SERVLET DE CADASTRO DE DISCIPLINA" + ex);
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
