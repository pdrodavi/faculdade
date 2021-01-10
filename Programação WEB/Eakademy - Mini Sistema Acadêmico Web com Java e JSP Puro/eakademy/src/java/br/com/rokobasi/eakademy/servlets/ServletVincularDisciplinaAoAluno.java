package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Disciplina_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vincDisciplinaAluno")
public class ServletVincularDisciplinaAoAluno extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            DisciplinaDAO dao = new DisciplinaDAO();
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("vincularDisciplinaAoAluno")) {

                int aluno = Integer.valueOf(req.getParameter("aluno"));
                int disciplina = Integer.valueOf(req.getParameter("disciplina"));
                dao.vincularDisciplinaAoAluno(aluno, disciplina);
                redirect(resp, "pages/coordenador/index", "Disciplina vinculada com sucesso!");

            } else if (type.equalsIgnoreCase("disciplinasDoCurso")) {

                    int id_curso = Integer.valueOf(req.getParameter("id_curso"));
                    DisciplinaDAO daoDisciplina = new DisciplinaDAO();
                    ArrayList<Disciplina_Curso> disciplinas_curso = (ArrayList<Disciplina_Curso>) daoDisciplina.getDisciplinasByCurso(id_curso);
                    req.setAttribute("disciplinasDoCurso", disciplinas_curso);
                    req.getRequestDispatcher("pages/coordenador/vincularDisciplinaAoAluno.jsp").forward(req, resp);

            } else {
                redirect(resp, "pages/coordenador/matricularAluno", "Não foi possível matricular o aluno!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE VINCULO DISCIPLINA AO ALUNO" + ex);
        }

    }

    public void redirect(HttpServletResponse resp, String pagina, String msg) throws IOException {

        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location='" + pagina + ".jsp';");
        out.println("alert('" + msg + "');");
        out.println("alert('Operação realizada com sucesso!');");
        out.println("</script>");

    }
    
}
