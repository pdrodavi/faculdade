package br.com.rokobasi.eakademy.servlets;

import br.com.rokobasi.eakademy.dao.DisciplinaDAO;
import br.com.rokobasi.eakademy.model.Alunos_Disciplina;
import br.com.rokobasi.eakademy.model.Disciplinas_Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadNotas")
public class ServletCadastrarNotas extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String param = req.getParameter("param");

            if (param.equalsIgnoreCase("cadastrarNotasAluno")) {

                //Alunos_Disciplina aluno = (Alunos_Disciplina)req.getAttribute("aluno");
                
                int id_aluno = Integer.valueOf(req.getParameter("aluno"));
                int id_disciplina = Integer.valueOf(req.getParameter("disciplina"));
                //int id_aluno = Long.valueOf(id_aluno.toString());
                //int id_disciplina = Integer.valueOf(aluno.getId_disciplina().toString());
               
                double nota1 = Double.valueOf(req.getParameter("nota1"));
                double nota2 = Double.valueOf(req.getParameter("nota2"));
                double nota3 = Double.valueOf(req.getParameter("nota3"));
                
                DisciplinaDAO dao = new DisciplinaDAO();
                dao.cadastrarNotaAluno(id_aluno, nota1, nota2, nota3, id_disciplina);
                
                redirect(resp, "pages/professor/index", "Notas cadastradas com sucesso!");

            } else if (param.equalsIgnoreCase("visualizarDisciplinasDoProfessorForAlunos")) {

                int id_professor = Integer.valueOf(req.getParameter("id_professor"));
                
                // método pra retornar as disciplinas do professor pelo id
                DisciplinaDAO dao = new DisciplinaDAO();
                ArrayList<Disciplinas_Professor> disciplinasProfessor = (ArrayList<Disciplinas_Professor>) dao.getDisciplinasProfessorByID(id_professor);
                req.setAttribute("disciplinasDoProfessor", disciplinasProfessor);
                req.getRequestDispatcher("pages/professor/disciplinasProfessor.jsp").forward(req, resp);

            } else if(param.equalsIgnoreCase("visualizarAlunosPorDisciplina")){
                
                int id_disciplina = Integer.valueOf(req.getParameter("disciplina"));
                // consultar alunos vinculados aquela disciplina e dispachar para cadastro
                DisciplinaDAO dao = new DisciplinaDAO();
                ArrayList<Alunos_Disciplina> alunosDisciplina = (ArrayList<Alunos_Disciplina>) dao.getAlunosByDisciplina(id_disciplina);
                req.setAttribute("alunosDaDisciplina", alunosDisciplina);
                req.setAttribute("id_disciplina", id_disciplina);
                req.getRequestDispatcher("pages/professor/cadastrarNotas.jsp").forward(req, resp);
            
            } else {
                redirect(resp, "pages/coordenador/cadastrarDisciplina", "Não foi possível cadastrar a disciplina!");
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERRO NO SERVLET DE CADASTRO DE NOTAS" + ex);
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
