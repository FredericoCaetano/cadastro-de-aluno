package br.edu.unicid.dao;

import java.sql.*;
import br.edu.unicid.model.Aluno;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {
    private Connection conn;
    private PreparedStatement ps;

    ResultSet rs;
    Aluno aluno;

    // Conectando com Banco
    public AlunoDAO() throws Exception {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    // Metedo Salvar
    public void salvar(Aluno aluno) throws Exception {
        if (aluno == null)
            throw new Exception("Valor não pode ser nulo!");
        try {
            String SQL = "INSERT INTO cadastrodealuno (rgm, nome, dataNasc, cpf, email, endereco, municipio, uf, celular, curso, campus, periodo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, aluno.getRgm());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getDataNasc());
            ps.setString(4, aluno.getCpf());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getEndereco());
            ps.setString(7, aluno.getMunicipio());
            ps.setString(8, aluno.getUf());
            ps.setString(9, aluno.getCelular());
            ps.setString(10, aluno.getCurso());
            ps.setString(11, aluno.getCampus());
            ps.setString(12, aluno.getPeriodo());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir os dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // Metodo Alterar
    public void alterar(Aluno aluno) throws Exception {
        try {
            String SQL = "UPDATE cadastrodealuno SET nome=?, dataNasc=?, cpf=?, email=?, endereco=?, municipio=?, uf=?, celular=?, curso=?, campus=?, periodo=? WHERE rgm=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDataNasc());
            ps.setString(3, aluno.getCpf());
            ps.setString(4, aluno.getEmail());
            ps.setString(5, aluno.getEndereco());
            ps.setString(6, aluno.getMunicipio());
            ps.setString(7, aluno.getUf());
            ps.setString(8, aluno.getCelular());
            ps.setString(9, aluno.getCurso());
            ps.setString(10, aluno.getCampus());
            ps.setString(11, aluno.getPeriodo());
            ps.setInt(12, aluno.getRgm());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar os dados " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // Metodo Deletar
    public void deletar(int rgm) throws Exception {
        try {
            String sql = "DELETE FROM cadastrodealuno WHERE rgm=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rgm);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Erro ao excluir" + e.getMessage());
        }
    }

    // Metodo Consultar
    public Aluno consultar(int rgm) throws Exception {
        try {
            ps = conn.prepareStatement("SELECT * FROM cadastrodealuno WHERE rgm=?");
            ps.setInt(1, rgm);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String dataNasc = rs.getString("dataNasc");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String municipio = rs.getString("municipio");
                String uf = rs.getString("uf");
                String celular = rs.getString("celular");
                String curso = rs.getString("curso");
                String campus = rs.getString("campus");
                String periodo = rs.getString("periodo");
                aluno = new Aluno(rgm, nome, dataNasc, cpf, email, endereco, municipio, uf, celular, curso, campus,
                        periodo);
            }
            return aluno;

        } catch (Exception e) {
            throw new Exception("Erro ao listar" + e.getMessage());
        }
    }
}