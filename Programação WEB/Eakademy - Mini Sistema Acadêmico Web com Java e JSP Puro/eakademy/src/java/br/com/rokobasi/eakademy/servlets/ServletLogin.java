package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.CursoDAO;
import br.com.rokobasi.eakademy.dao.LoginDAO;
import br.com.rokobasi.eakademy.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginUser")
public class ServletLogin extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginDAO loginDAO = new LoginDAO();
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");
        // parametro recebido do input
        String param = req.getParameter("param");

        Login l = loginDAO.autenticacao(cpf, senha);

        if (param != null && param.equals("logout")) {

            req.getSession().invalidate();
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            redirect(resp, "login", "Sessão finalizada com sucesso!");

        } else {

            if (l != null) {
                
                if (l.getPerfil().equalsIgnoreCase("diretor")) {
                    
                    String perfil = l.getPerfil();
                    req.setAttribute("perfil", l);
                    // iniciando sessão com chave para expression language
                    req.getSession().setAttribute("login", l);
                    resp.sendRedirect("pages/" + perfil + "/index.jsp");
                    // usar so quando quiser mandar um objeto para outra pagina
                    //req.getRequestDispatcher("pages/" + perfil + "/index.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/listaDeCoordenadores.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/cadastrarCoordenador.jsp").forward(req, resp);
                
                } else if (l.getPerfil().equalsIgnoreCase("coordenador")) {
                    
                    CursoDAO dao = new CursoDAO();
                    int totalDeAlunos = dao.getTotalDeAlunosByCurso(l.getCurso());
                    
                    String perfil = l.getPerfil();
                    req.setAttribute("perfil", l);
                    req.setAttribute("totalDeAlunos", totalDeAlunos);
                    req.getSession().setAttribute("login", l);
                    req.getSession().setAttribute("totalDeAlunos", totalDeAlunos);
                    resp.sendRedirect("pages/" + perfil + "/index.jsp");
                    // usar so quando quiser mandar um objeto para outra pagina
                    //req.getRequestDispatcher("pages/" + perfil + "/index.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/cadastrarDisciplina.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/cadastrarTurma.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/visualizarDisciplinasCurso.jsp").forward(req, resp);
                
                } else if (l.getPerfil().equalsIgnoreCase("professor")) {
                    
                    String perfil = l.getPerfil();
                    req.setAttribute("perfil", l);
                    req.getSession().setAttribute("login", l);
                    resp.sendRedirect("pages/" + perfil + "/index.jsp");
                    // usar so quando quiser mandar um objeto para outra pagina
                    //req.getRequestDispatcher("pages/" + perfil + "/index.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/visualizarTurmas.jsp").forward(req, resp);
                    //req.getRequestDispatcher("pages/" + perfil + "/RelatorioTurmas.jsp").forward(req, resp);
                
                } else if (l.getPerfil().equalsIgnoreCase("aluno")) {
                    String perfil = l.getPerfil();
                    req.setAttribute("perfil", l);
                    req.getSession().setAttribute("login", l);
                    resp.sendRedirect("pages/" + perfil + "/index.jsp");
                }
                
            } else {
                redirect(resp, "login", "Não foi possível iniciar sua sessão!");
            }

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
