package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Coordenador;
import br.com.rokobasi.eakademy.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();

    public void cadastrarUsuario(Usuario usuario) {

        String sql = "insert into usuarios values(default,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getEndereco());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getTelefone());
            ps.setString(6, usuario.getSenha());
            ps.setString(7, usuario.getPerfil());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no usuárioDAO Cadastro: " + ex);
        }

    }
    
    public void cadastrarCoordenador(Coordenador coordenador) {

        String sql = "insert into usuarios values(default,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, coordenador.getNome());
            ps.setString(2, coordenador.getCpf());
            ps.setString(3, coordenador.getEndereco());
            ps.setString(4, coordenador.getEmail());
            ps.setString(5, coordenador.getTelefone());
            ps.setString(6, coordenador.getSenha());
            ps.setString(7, coordenador.getPerfil());
            ps.setLong(8, coordenador.getCurso());
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no usuárioDAO Cadastro: " + ex);
        }

    }

    public List<Usuario> getAll() {

        List<Usuario> usuarios = new ArrayList();
        String sql = "select * from usuarios";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Usuario user = new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), 
                        rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"), 
                        rs.getString("perfil"));
                
                if(!"aluno".equals(user.getPerfil())){
                    usuarios.add(user);
                }
                //usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"),
                 //       rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"), rs.getString("perfil")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Usuarios DAO: " + ex);
        }
        return usuarios;
    }
    
    public List<Usuario> getCoordenadores(){
    
        List<Usuario> usuarios = new ArrayList();
        String sql = "select * from usuarios where perfil = 'coordenador'";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"), rs.getString("perfil")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Usuarios DAO: " + ex);
        }
        return usuarios;
    }
    
    public List<Usuario> getProfessores(){
    
        List<Usuario> usuarios = new ArrayList();
        String sql = "select * from usuarios where perfil = 'professor'";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"), rs.getString("perfil")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Usuarios DAO: " + ex);
        }
        return usuarios;
        
    }
    
    public List<Usuario> getAlunos(){
    
        List<Usuario> usuarios = new ArrayList();
        String sql = "select * from usuarios where perfil = 'aluno'";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"), rs.getString("perfil")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Usuarios DAO: " + ex);
        }
        return usuarios;
        
    }

    public Usuario getUsuarioById(Long id) {
        Usuario usuario = new Usuario();
        String sql = "select * from usuarios where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfil(rs.getString("perfil"));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getUsuarioByID: " + ex);
        }

        return usuario;
    }

    public void updateUsuario(Usuario usuario) {

        String sql = "update usuarios set nome=?, cpf=?, endereco=?, email=?, telefone=?, senha=?, perfil=? where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getEndereco());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getTelefone());
            ps.setString(6, usuario.getSenha());
            ps.setString(7, usuario.getPerfil());
            ps.setLong(8, usuario.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em atualizar usuario: " + ex);
        }
    }

    public void excluir(Long id) {
        String sql = "delete from usuarios where id=?";
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
    
    public void vincularProfessorAoCurso(int professor, int curso){
    
        String sql = "insert into professor_curso values (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, professor);
            ps.setLong(2, curso);
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no vincularProfessorAoCurso DAO: " + ex);
        }
    
    }
    
    public void vincularProfessorATurma(int professor, int turma){
    
        String sql = "insert into professor_turma values (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, professor);
            ps.setLong(2, turma);
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no vincularProfessorATurma DAO: " + ex);
        }
    
    }
    
    public void vincularDisciplinaAoProfessor(int professor, int disciplina){
    
        String sql = "insert into disciplinas_professor values (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, professor);
            ps.setLong(2, disciplina);
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no vincularDisciplinaAoProfessor DAO: " + ex);
        }
    
    }
    
    public void matricularAlunoATurma(int aluno, int turma){
    
        String sql = "insert into aluno_turma values (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, aluno);
            ps.setLong(2, turma);
            ps.executeUpdate();     
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no matricularAluno DAO: " + ex);
        }
    
    }

}
