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

@WebServlet("/editVestibular")
public class ServletEditarVestibular extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Vestibular vest = null;
            VestibularDAO dao = new VestibularDAO();
            String nome = req.getParameter("nome");
            String data = req.getParameter("data");
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("editarVestibular")) {

                Long id = Long.valueOf(req.getParameter("id"));

                vest = new Vestibular(id, nome, data);
                dao.updateVestibular(vest);
                
                redirect(resp, "pages/diretor/listaDeVestibular", "Vestibular editado com sucesso!");

            } else {
                redirect(resp, "pages/diretor/listaDeVestibular", "Não foi possível editar o vestibular!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE EDITAR VESTIBULAR" + ex);
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
