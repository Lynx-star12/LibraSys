package br.edu.ifrn.libra.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.libra.modelo.Secao;

public class SecaoRepositorio {

    private Connection getConnection() throws SQLException {
        return GerenciadorDeConexao.getConnection();
    }

    // [C] - INSERIR (INSERT)
    public void inserir(Secao secao) {
        String sql = "INSERT INTO secao (nome_genero, codigo, localizacao, capacidade_maxima, livros_ocupados) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, secao.getNomeGenero());
            stmt.setString(2, secao.getCodigo());
            stmt.setString(3, secao.getLocalizacao());
            stmt.setInt(4, secao.getCapacidadeMaxima());
            stmt.setInt(5, secao.getLivrosOcupados());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    secao.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir seção no MySQL", e);
        }
    }

    // [R] - SELECIONAR / LISTAR (SELECT)
    public List<Secao> selecionarTodas() {
        List<Secao> secoes = new ArrayList<>();
        String sql = "SELECT * FROM secao";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                secoes.add(mapearLinha(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar seções do MySQL", e);
        }
        return secoes;
    }

    // Usado pelo servico para checar duplicidade de gênero
    public Secao buscarPorNomeGenero(String nomeGenero) {
        return buscarPorCampo("nome_genero", nomeGenero);
    }

    // Usado pelo servico para checar duplicidade de código
    public Secao buscarPorCodigo(String codigo) {
        return buscarPorCampo("codigo", codigo);
    }

    private Secao buscarPorCampo(String coluna, String valor) {
        String sql = "SELECT * FROM secao WHERE " + coluna + " = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, valor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearLinha(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar seção no MySQL", e);
        }
        return null;
    }

    // [U] - ATUALIZAR (UPDATE)
    public void atualizar(Secao secao) {
        String sql = "UPDATE secao SET nome_genero = ?, codigo = ?, localizacao = ?, capacidade_maxima = ?, livros_ocupados = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, secao.getNomeGenero());
            stmt.setString(2, secao.getCodigo());
            stmt.setString(3, secao.getLocalizacao());
            stmt.setInt(4, secao.getCapacidadeMaxima());
            stmt.setInt(5, secao.getLivrosOcupados());
            stmt.setLong(6, secao.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar seção no MySQL", e);
        }
    }

    // [D] - EXCLUIR (DELETE)
    public void excluir(Long id) {
        String sql = "DELETE FROM secao WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir seção do MySQL", e);
        }
    }

    private Secao mapearLinha(ResultSet rs) throws SQLException {
        Secao secao = new Secao();
        secao.setId(rs.getLong("id"));
        secao.setNomeGenero(rs.getString("nome_genero"));
        secao.setCodigo(rs.getString("codigo"));
        secao.setLocalizacao(rs.getString("localizacao"));
        secao.setCapacidadeMaxima(rs.getInt("capacidade_maxima"));
        secao.setLivrosOcupados(rs.getInt("livros_ocupados"));
        return secao;
    }
}