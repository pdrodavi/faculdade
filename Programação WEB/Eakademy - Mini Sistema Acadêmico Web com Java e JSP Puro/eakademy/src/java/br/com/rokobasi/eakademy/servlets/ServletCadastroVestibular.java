package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.VestibularDAO;
import br.com.rokobasi.eakademy.model.Vestibular;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadVest")
public class ServletCadastroVestibular extends HttpServlet {
    
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Vestibular vest = null;
            VestibularDAO dao = new VestibularDAO();
            String nome = req.getParameter("nome");
            String data = req.getParameter("data");
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("cadastrarVestibular")) {

                vest = new Vestibular(nome, data);
                dao.cadastrarVestibular(vest);
                
                redirect(resp, "pages/diretor/cadastrarVestibular", "Vestibular cadastrado com sucesso!");

            } else {
                redirect(resp, "pages/diretor/cadastrarVestibular", "Não foi possível cadastrar o vestibular!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE CADASTRO DE VESTIBULAR" + ex);
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
