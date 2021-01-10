package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Curso;
import br.com.rokobasi.eakademy.model.Professor_Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();

    public void cadastrarCurso(Curso curso) {

        String sql = "insert into curso values(default,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getArea());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no cursoDAO CADASTRAR CURSO: " + ex);
        }

    }

    public List<Curso> getAll() {

        List<Curso> cursos = new ArrayList();
        String sql = "select * from curso";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getLong("id"), rs.getString("nome_curso"), rs.getString("area")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Cursos DAO: " + ex);
        }
        return cursos;
    }

    public void excluir(Long id) {

        String sql = "delete from curso where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em Excluir cursoDAO: " + ex);
        }
    }

    public List<Professor_Curso> getProfessoresDeCurso(int id_curso) {

        List<Professor_Curso> professores_curso = new ArrayList();
        String sql = "SELECT usuarios.nome, curso.nome_curso from professor_curso "
                + "JOIN curso on (professor_curso.id_curso = curso.id) "
                + "JOIN usuarios on (professor_curso.id_usuario = usuarios.id) "
                + "WHERE usuarios.perfil = 'professor' AND professor_curso.id_curso = " + id_curso;

        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professores_curso.add(new Professor_Curso(rs.getString("nome"), rs.getString("nome_curso")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar professores por ID do curso " + ex);
        }
        return professores_curso;
    }
    
    public Curso getCursoById(Long id){
    
        Curso curso = new Curso();
        String sql = "select * from curso where id=?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            
            while (rs.next()) {
                curso.setId(rs.getLong("id"));
                curso.setNome(rs.getString("nome_curso"));
                curso.setArea(rs.getString("area"));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getCursoByID: " + ex);
        }
        
        return curso;        
    }
    
    public void updateCurso(Curso curso) {

        String sql = "update curso set nome_curso=?, area=? where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getArea());
            ps.setLong(3, curso.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em atualizar curso dao: " + ex);
        }
    }
    
    public int getTotalDeAlunosByCurso(int id_curso){
        
        int totalDeAlunos = 0;
        
        String sql = "SELECT DISTINCT usuarios.nome from aluno_turma "
                + "JOIN turma on (aluno_turma.id_turma = turma.id) "
                + "JOIN usuarios on (aluno_turma.id_usuario = usuarios.id) "
                + "WHERE usuarios.perfil = 'aluno' AND turma.curso_idcurso = " + id_curso;
        
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                totalDeAlunos++;
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getTotalDeAlunosByCurso: " + ex);
        }
        
        //System.out.println("TOTAL DE ALUNOS: " + totalDeAlunos);
        return totalDeAlunos;
    }

}
