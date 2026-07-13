package br.edu.ifrn.libra.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.libra.modelo.usuario;

public class Usuariorepositorio {

    private Connection getConnection() throws SQLException {
        return GerenciadorDeConexao.getConnection();
    }

    // [C] - INSERIR (INSERT)
    public void inserir(usuario usuarioParaSalvar) {
        String sql = "INSERT INTO usuario (nome_completo, cpf, email, telefone, status_cadastro, limite_emprestimos, emprestimos_ativos) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuarioParaSalvar.getNomeCompleto());
            stmt.setString(2, usuarioParaSalvar.getCpf());
            stmt.setString(3, usuarioParaSalvar.getEmail());
            stmt.setString(4, usuarioParaSalvar.getTelefone());
            stmt.setString(5, usuarioParaSalvar.getStatusCadastro());
            stmt.setInt(6, usuarioParaSalvar.getLimiteEmprestimos());
            stmt.setInt(7, usuarioParaSalvar.getEmprestimosAtivos());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuarioParaSalvar.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir usuário no MySQL", e);
        }
    }

    // [R] - SELECIONAR / LISTAR (SELECT)
    public List<usuario> selecionarTodos() {
        List<usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                usuarios.add(mapearLinha(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar usuários do MySQL", e);
        }
        return usuarios;
    }

    // Usado pelo usuarioServico para checar CPF duplicado
    public usuario buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM usuario WHERE cpf = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearLinha(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por CPF no MySQL", e);
        }
        return null;
    }

    // [U] - ATUALIZAR (UPDATE)
    public void atualizar(usuario usuarioParaAtualizar) {
        String sql = "UPDATE usuario SET nome_completo = ?, cpf = ?, email = ?, telefone = ?, status_cadastro = ?, limite_emprestimos = ?, emprestimos_ativos = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuarioParaAtualizar.getNomeCompleto());
            stmt.setString(2, usuarioParaAtualizar.getCpf());
            stmt.setString(3, usuarioParaAtualizar.getEmail());
            stmt.setString(4, usuarioParaAtualizar.getTelefone());
            stmt.setString(5, usuarioParaAtualizar.getStatusCadastro());
            stmt.setInt(6, usuarioParaAtualizar.getLimiteEmprestimos());
            stmt.setInt(7, usuarioParaAtualizar.getEmprestimosAtivos());
            stmt.setLong(8, usuarioParaAtualizar.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário no MySQL", e);
        }
    }

    // [D] - EXCLUIR (DELETE)
    public void excluir(Long id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário do MySQL", e);
        }
    }

    private usuario mapearLinha(ResultSet rs) throws SQLException {
        usuario usuarioEncontrado = new usuario();
        usuarioEncontrado.setId(rs.getLong("id"));
        usuarioEncontrado.setNomeCompleto(rs.getString("nome_completo"));
        usuarioEncontrado.setCpf(rs.getString("cpf"));
        usuarioEncontrado.setEmail(rs.getString("email"));
        usuarioEncontrado.setTelefone(rs.getString("telefone"));
        usuarioEncontrado.setStatusCadastro(rs.getString("status_cadastro"));
        usuarioEncontrado.setLimiteEmprestimos(rs.getInt("limite_emprestimos"));
        usuarioEncontrado.setEmprestimosAtivos(rs.getInt("emprestimos_ativos"));
        return usuarioEncontrado;
    }
}