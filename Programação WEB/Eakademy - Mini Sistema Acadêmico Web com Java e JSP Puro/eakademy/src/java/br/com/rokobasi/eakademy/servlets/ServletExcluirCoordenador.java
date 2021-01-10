/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro Davi
 */
@WebServlet("/delCoordenador")
public class ServletExcluirCoordenador extends HttpServlet {
            
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            UsuarioDAO dao = new UsuarioDAO();
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("excluirCoordenador")) {

                Long id = Long.valueOf(req.getParameter("id"));
                dao.excluir(id);                
                redirect(resp, "pages/diretor/listaDeCoordenadores", "Coordenador excluido com sucesso!");

            } else {
                redirect(resp, "pages/diretor/listaDeCoordenadores", "Não foi possível excluir o coordenador!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE EXCLUIR COORDENADOR" + ex);
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
