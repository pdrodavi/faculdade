package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.UsuarioDAO;
import br.com.rokobasi.eakademy.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/editProfessor")
public class ServletEditarProfessor extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Usuario user = null;
            UsuarioDAO dao = new UsuarioDAO();
            String nome = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            String endereco = req.getParameter("endereco");
            String email = req.getParameter("email");
            String telefone = req.getParameter("telefone");
            String senha = req.getParameter("senha");
            String perfil = req.getParameter("perfil");
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("editarProfessor")) {

                Long id = Long.valueOf(req.getParameter("id"));
                user = new Usuario(id, nome, cpf, endereco, email, telefone, senha, perfil);
                dao.updateUsuario(user);
                
                redirect(resp, "pages/diretor/listaDeProfessores", "Professor editado com sucesso!");
                
            } else {
                redirect(resp, "pages/diretor/listaDeProfessores", "Não foi possível editar o Professor!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE EDITAR PROFESSOR" + ex);
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
