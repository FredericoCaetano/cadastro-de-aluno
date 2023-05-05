package br.edu.unicid.dao;

import java.sql.*;
import br.edu.unicid.model.Aluno2;
import br.edu.unicid.util.ConnectionFactory;

//Conectando com o Banco
public class AlunoDAO2 {
    private Connection conn2;
    private PreparedStatement ps2;

    public AlunoDAO2() throws Exception {
        try {
            conn2 = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro " + e.getMessage());
        }
    }

    // Metodo Salvar
    public void salvar2(Aluno2 aluno2) throws Exception {
        try {
            String sql2 = "INSERT INTO notasfaltas(disciplina, semestre, nota, faltas, rgm, nome, curso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps2 = conn2.prepareStatement(sql2);
            ps2.setString(1, aluno2.getDisciplina());
            ps2.setString(2, aluno2.getSemestre());
            ps2.setDouble(3, aluno2.getNota());
            ps2.setInt(4, aluno2.getFaltas());
            ps2.setInt(5, aluno2.getAluno().getRgm());
            ps2.setString(6, aluno2.getAluno().getNome());
            ps2.setString(7, aluno2.getAluno().getCurso());
            ps2.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Erro ao salvar" + e.getMessage());
        }
    }

    // Metodo Alterar
    public void alterar2(Aluno2 aluno2) throws Exception {
        try {
            String sql2 = "UPDATE notasfaltas SET disciplina=?, semestre=?, nota=?, FALTA=?, nome=?, curso=? WHERE rgm=?";
            ps2 = conn2.prepareStatement(sql2);
            ps2.setString(1, aluno2.getDisciplina());
            ps2.setString(2, aluno2.getSemestre());
            ps2.setDouble(3, aluno2.getNota());
            ps2.setInt(4, aluno2.getFaltas());
            ps2.setString(5, aluno2.getAluno().getNome());
            ps2.setString(6, aluno2.getAluno().getCurso());
            ps2.setInt(7, aluno2.getAluno().getRgm());
            ps2.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Erro ao Alterar" + e.getMessage());
        }
    }

    // Metodo Deletar
    public void deletar2(int rgm) throws Exception {
        try {
            String sql2 = "DELETE FROM notasfaltas "
                    + " WHERE rgm=?";
            ps2 = conn2.prepareStatement(sql2);
            ps2.setInt(1, rgm);
            ps2.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Erro ao excluir" + e.getMessage());
        }
    }
}