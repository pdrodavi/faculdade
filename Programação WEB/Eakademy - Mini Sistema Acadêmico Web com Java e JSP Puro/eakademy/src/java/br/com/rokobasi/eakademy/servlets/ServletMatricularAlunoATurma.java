package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.TurmaDAO;
import br.com.rokobasi.eakademy.dao.UsuarioDAO;
import br.com.rokobasi.eakademy.model.Turmas_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/matAlunoTurma")
public class ServletMatricularAlunoATurma extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            UsuarioDAO dao = new UsuarioDAO();
            String type = req.getParameter("param");

            if (type.equalsIgnoreCase("matricularAlunoTurma")) {

                int aluno = Integer.valueOf(req.getParameter("aluno"));
                int turma = Integer.valueOf(req.getParameter("turma"));
                dao.matricularAlunoATurma(aluno, turma);
                redirect(resp, "pages/coordenador/index", "Aluno matriculado com sucesso!");

            } else if (type.equalsIgnoreCase("turmasDoCurso")) {

                    int id_curso = Integer.valueOf(req.getParameter("id_curso"));
                    TurmaDAO daoTurma = new TurmaDAO();
                    ArrayList<Turmas_Curso> turmas_curso = (ArrayList<Turmas_Curso>) daoTurma.getTurmasDeCurso(id_curso);
                    req.setAttribute("turmasDoCurso", turmas_curso);
                    req.getRequestDispatcher("pages/coordenador/matricularAluno.jsp").forward(req, resp);

            } else {
                redirect(resp, "pages/coordenador/matricularAluno", "Não foi possível matricular o aluno!");
            }
        } catch (Exception ex) {
            System.out.println("ERRO NO SERVLET DE MATRICULA" + ex);
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
