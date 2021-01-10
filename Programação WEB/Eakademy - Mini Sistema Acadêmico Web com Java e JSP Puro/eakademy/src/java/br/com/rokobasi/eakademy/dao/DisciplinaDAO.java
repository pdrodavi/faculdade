package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Alunos_Disciplina;
import br.com.rokobasi.eakademy.model.Disciplina;
import br.com.rokobasi.eakademy.model.Disciplina_Curso;
import br.com.rokobasi.eakademy.model.Disciplinas_Aluno;
import br.com.rokobasi.eakademy.model.Disciplinas_Professor;
import br.com.rokobasi.eakademy.model.Disciplinas_Professores;
import br.com.rokobasi.eakademy.model.Notas_Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    
    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();
    
    public void cadastrarDisciplina(Disciplina disciplina){
        
        // conferir qual coordenador ta tentando fazer o cadastro de disciplina
        
        String sql = "insert into disciplina values(default,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, disciplina.getId_curso());
            ps.setString(2, disciplina.getNome());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no disciplinaDAO Cadastro: " + ex);
        }
        
    }
    
    public void excluir(Long id) {
        String sql = "delete from disciplina where id_disciplina=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em Excluir usuárioDAO: " + ex);
        }

    }
    
    public List<Disciplina> getAll(){

        List<Disciplina> disciplinas = new ArrayList();
        String sql = "select * from disciplina";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinas.add(new Disciplina(rs.getLong("id_disciplina"), rs.getLong("id_curso"), rs.getString("nome_disciplina")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Cursos DAO: " + ex);
        }
        return disciplinas;
    }
    
    public List<Disciplina_Curso> getDisciplinasEcursos(){
        
        List<Disciplina_Curso> disciplinas_curso = new ArrayList();
        String sql = "select d.nome_disciplina, c.nome from disciplina d join curso c on c.id = d.id_curso";
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinas_curso.add(new Disciplina_Curso(rs.getString("nome"), rs.getString("nome_disciplina")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar vinculo de Disciplinas com Cursos " + ex);
        }
        return disciplinas_curso;
    }
    
    public List<Disciplina_Curso> getDisciplinasDeCurso(int id_curso){
        
        List<Disciplina_Curso> disciplinas_curso = new ArrayList();
        String sql = "SELECT dis.nome_disciplina, cur.nome_curso FROM disciplina dis "
                + "INNER JOIN curso cur ON (dis.id_curso = cur.id) "
                + "WHERE cur.id = " + id_curso;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                disciplinas_curso.add(new Disciplina_Curso(rs.getString("nome_disciplina"), rs.getString("nome_curso")));
                //disciplinas_curso.add(new Disciplina_Curso(rs.getString("id"), rs.getString("nome_disciplina"), rs.getString("nome_curso")));
                // acrescentar coluna id na tabela de vinculo disciplinas_curso
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar vinculo de Disciplinas com Cursos por ID do curso " + ex);
        }
        return disciplinas_curso;
    }
    
    public List<Disciplina_Curso> getDisciplinasByCurso(int id_curso){
        
        List<Disciplina_Curso> disciplinas_curso = new ArrayList();
        String sql = "SELECT dis.nome_disciplina, dis.id_disciplina, cur.nome_curso FROM disciplina dis "
                + "INNER JOIN curso cur ON (dis.id_curso = cur.id) "
                + "WHERE cur.id = " + id_curso;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //disciplinas_curso.add(new Disciplina_Curso(rs.getString("nome_disciplina"), rs.getString("nome_curso")));
                disciplinas_curso.add(new Disciplina_Curso(rs.getLong("id_disciplina"), rs.getString("nome_disciplina"), rs.getString("nome_curso")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar vinculo de Disciplinas com Cursos por ID do curso " + ex);
        }
        return disciplinas_curso;
    }
    
    public List<Disciplinas_Professores> getDisciplinasDosProfessores(int id_curso){
        
        List<Disciplinas_Professores> disciplinas_professores = new ArrayList();
        String sql = "SELECT disciplina.nome_disciplina, usuarios.nome FROM disciplinas_professor "
                + "JOIN disciplina ON (disciplinas_professor.id_disciplina = disciplina.id_disciplina) "
                + "JOIN usuarios ON (disciplinas_professor.id_usuario = usuarios.id) "
                + "JOIN curso ON (disciplina.id_curso = curso.id) "
                + "WHERE curso.id = " + id_curso;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinas_professores.add(new Disciplinas_Professores(rs.getString("nome_disciplina"), rs.getString("nome")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar vinculo de Disciplinas dos Professores por ID do Curso " + ex);
        }
        return disciplinas_professores;
    }
    
    public void vincularDisciplinaAoAluno(int aluno, int disciplina){
    
        String sql = "insert into disciplinas_aluno values (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, aluno);
            ps.setLong(2, disciplina);
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no vincularDisciplinaAoAluno DAO: " + ex);
        }
    
    }
    
    public void cadastrarNotaAluno(int id_aluno, double nota1, double nota2, double nota3, int id_disciplina){
        
        String sql = "insert into aluno_disciplina_nota values (default,?,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            Double media = (nota1 + nota2 + nota3)/3;
            String situacao;
            
            if(media >= 7){
                situacao = "APROVADO";
            }else if(media > 4  && media < 7){
                situacao = "RECUPERAÇÃO";
            }else{
                situacao = "REPROVADO";
            }
            
            ps.setLong(1, id_aluno);
            ps.setDouble(2, nota1);
            ps.setDouble(3, nota2);
            ps.setDouble(4, nota3);
            ps.setInt(5, id_disciplina);
            ps.setDouble(6, media);
            ps.setString(7, situacao);
            ps.executeUpdate();     
            ps.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("ERRO no cadastrarNotas DAO: " + ex);
        }
    
    }
    
    public List<Disciplinas_Professor> getDisciplinasProfessorByID(int id_professor){
        
        List<Disciplinas_Professor> disciplinasProfessor = new ArrayList();
        
        String sql = "select disciplina.id_disciplina, disciplina.nome_disciplina from disciplinas_professor "
                + "inner join disciplina on (disciplinas_professor.id_disciplina = disciplina.id_disciplina) "
                + "inner join usuarios on (disciplinas_professor.id_usuario = usuarios.id) "
                + "where disciplinas_professor.id_usuario = " + id_professor;
                      
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinasProfessor.add(new Disciplinas_Professor(rs.getLong("id_disciplina"), rs.getString("nome_disciplina")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no buscar disciplinas do professor pelo id DAO: " + ex);
        }
        return disciplinasProfessor;
    }
    
    public List<Disciplinas_Aluno> getDisciplinasDoAluno(int id_aluno){
    
        List<Disciplinas_Aluno> disciplinasAluno = new ArrayList();
        
        String sql = "select disciplina.id_disciplina, disciplina.nome_disciplina from disciplinas_aluno "
                + "inner join disciplina on (disciplinas_aluno.id_disciplina = disciplina.id_disciplina) "
                + "inner join usuarios on (disciplinas_aluno.id_usuario = usuarios.id) "
                + "where usuarios.id = " + id_aluno;
                      
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinasAluno.add(new Disciplinas_Aluno(rs.getLong("id_disciplina"), rs.getString("nome_disciplina")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no buscar disciplinas do aluno pelo id DAO: " + ex);
        }
        
        return disciplinasAluno;
    }
    
    public List<Notas_Disciplina> getNotasByDisciplina(int id_disciplina, int id_aluno){
    
        List<Notas_Disciplina> notasAluno = new ArrayList();
        
        String sql = "select disciplina.id_disciplina, disciplina.nome_disciplina, "
                + "aluno_disciplina_nota.nota1, aluno_disciplina_nota.nota2, aluno_disciplina_nota.nota3, "
                + "aluno_disciplina_nota.media, aluno_disciplina_nota.situacao from aluno_disciplina_nota "
                + "inner join disciplina on (aluno_disciplina_nota.id_disciplina = disciplina.id_disciplina) "
                + "inner join usuarios on (aluno_disciplina_nota.id_aluno = usuarios.id) "
                + "where usuarios.id = " + id_aluno + " and disciplina.id_disciplina = " + id_disciplina;
                      
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                notasAluno.add(new Notas_Disciplina(rs.getLong("id_disciplina"), 
                        rs.getString("nome_disciplina"), 
                        rs.getFloat("nota1"), 
                        rs.getFloat("nota2"), 
                        rs.getFloat("nota3"), 
                        rs.getFloat("media"), 
                        rs.getString("situacao")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no buscar notas do aluno pela disciplina DAO: " + ex);
        }
        
        return notasAluno;
    }
    
    public List<Alunos_Disciplina> getAlunosByDisciplina(int id_disciplina){
        
        List<Alunos_Disciplina> disciplinasAluno = new ArrayList();
        
        String sql = "select usuarios.id, usuarios.nome, disciplina.id_disciplina from disciplinas_aluno "
                + "inner join disciplina on (disciplinas_aluno.id_disciplina = disciplina.id_disciplina) "
                + "inner join usuarios on (disciplinas_aluno.id_usuario = usuarios.id) "
                + "where disciplina.id_disciplina = " + id_disciplina;
                      
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                disciplinasAluno.add(new Alunos_Disciplina(rs.getLong("id"), rs.getString("nome"), rs.getLong("id_disciplina")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no buscar alunos pela disciplina DAO: " + ex);
        }
        return disciplinasAluno;
    }
    
}

