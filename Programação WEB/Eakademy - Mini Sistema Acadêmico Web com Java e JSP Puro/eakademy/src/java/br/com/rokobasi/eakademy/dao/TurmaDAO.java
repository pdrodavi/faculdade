package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Aluno_Turma;
import br.com.rokobasi.eakademy.model.Professor_Turma;
import br.com.rokobasi.eakademy.model.Professores_Turmas;
import br.com.rokobasi.eakademy.model.Turma;
import br.com.rokobasi.eakademy.model.Turmas_Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    
    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();
    
    public void cadastrarTurma(Turma turma){
        
        String sql = "insert into turma values(default,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, turma.getId_curso());
            ps.setLong(2, turma.getPeriodo());
            ps.setString(3, turma.getSigla());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no turmaDAO CADASTRAR TURMA: " + ex);
        }
    
    }
    
    public List<Turma> getAll(){

        List<Turma> turmas = new ArrayList();
        String sql = "select * from turma";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmas.add(new Turma(rs.getLong("id"), rs.getLong("curso_idcurso"), rs.getInt("periodo"), rs.getString("sigla")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getAll turmas DAO: " + ex);
        }
        return turmas;
    }
    
    public List<Professor_Turma> getTurmasProfessor(int id){
        
        List<Professor_Turma> turmasProfessor = new ArrayList();
        
        String sql = "select distinct sigla, periodo from professor_turma "
                      + "inner join turma on (professor_turma.id_usuario = " + id + ")";
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmasProfessor.add(new Professor_Turma(rs.getString("sigla"), rs.getInt("periodo")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar turmas do professor DAO: " + ex);
        }
        return turmasProfessor;
    }
    
    public List<Professor_Turma> getTurmasProfessorComID(int id){
        
        List<Professor_Turma> turmasProfessor = new ArrayList();
        
        String sql = "select distinct turma.id, sigla, periodo from professor_turma "
                + "inner join turma on (professor_turma.id_turma = turma.id) "
                + "where professor_turma.id_usuario = " + id;
                      
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmasProfessor.add(new Professor_Turma(rs.getLong("id"), rs.getString("sigla"), rs.getInt("periodo")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar turmas do professor DAO: " + ex);
        }
        return turmasProfessor;
    }
    
    public List<Turmas_Curso> getTurmasDeCurso(int id_curso){
        
        List<Turmas_Curso> turmas_curso = new ArrayList();
        String sql = "SELECT tur.sigla, tur.periodo, cur.nome_curso, tur.id FROM turma tur "
                + "INNER JOIN curso cur ON (tur.curso_idcurso = cur.id) "
                + "WHERE cur.id = " + id_curso;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmas_curso.add(new Turmas_Curso(rs.getLong("id"), rs.getString("sigla"), rs.getLong("periodo"), rs.getString("nome_curso")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar turmas por ID do curso " + ex);
        }
        return turmas_curso;
    }
    
    public List<Professores_Turmas> getTurmasProfessores(int id_curso){
        
        List<Professores_Turmas> turmasProfessores = new ArrayList();
        
        String sql = "select usuarios.nome, turma.sigla, turma.periodo from professor_turma "
                + "join usuarios on (professor_turma.id_usuario = usuarios.id) "
                + "join turma on (professor_turma.id_turma = turma.id) "
                + "join curso on (turma.curso_idcurso = curso.id) "
                + "where turma.curso_idcurso = " + id_curso;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmasProfessores.add(new Professores_Turmas(rs.getString("nome"), rs.getString("sigla"), rs.getInt("periodo")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar turmas do professor DAO: " + ex);
        }
        return turmasProfessores;
    }
    
    public List<Aluno_Turma> getAlunosByTurma(int id_turma){
        
        List<Aluno_Turma> alunos_turma = new ArrayList();
        
        String sql = "select distinct usuarios.nome, turma.sigla, turma.periodo from aluno_turma "
                + "join usuarios on (aluno_turma.id_usuario = usuarios.id) "
                + "join turma on (aluno_turma.id_turma = turma.id) "
                + "where turma.id = " + id_turma;
        
        PreparedStatement ps;
        
        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alunos_turma.add(new Aluno_Turma(rs.getString("nome"), rs.getString("sigla"), rs.getInt("periodo")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar alunos de turma DAO: " + ex);
        }
        return alunos_turma;
    }
    
}
