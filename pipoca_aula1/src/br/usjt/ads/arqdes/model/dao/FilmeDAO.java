package br.usjt.ads.arqdes.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.arqdes.model.entity.Filme;

public class FilmeDAO {
	
	public int inserirFilme(Filme filme) throws IOException {
		int id = -1;

		
		String sql = "insert into Filme (titulo, descricao, diretor, posterpath, popularidade, data_lancamento, id_genero) values (?,?,?,?,?,?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, filme.getTitulo());
			pst.setString(2, filme.getDescricao());
			pst.setString(3, filme.getDiretor());
			pst.setString(4, filme.getPosterPath());
			pst.setDouble(5, filme.getPopularidade());
			pst.setDate(6, new java.sql.Date(filme.getDataLancamento().getTime()));
			pst.setInt(7, filme.getGenero().getId());			
			pst.execute();
			
			//obter o id criado
			String query = "select LAST_INSERT_ID()";
			try(PreparedStatement pst1 = conn.prepareStatement(query);
				ResultSet rs = pst1.executeQuery();){

				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return filme.getId();
	}
	
	public int atualizarFilme(Filme filme) {
		String sqlUpdate = "UPDATE filme SET titulo=?, descricao=?, diretor=?, posterpath=?, popularidade=?, data_lancamento=?,id_genero=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sqlUpdate);){
				
					pst.setString(1, filme.getTitulo());
					pst.setString(2, filme.getDescricao());
					pst.setString(3, filme.getDiretor());
					pst.setString(4, filme.getPosterPath());
					pst.setDouble(5, filme.getPopularidade());
					pst.setDate(6, new java.sql.Date(filme.getDataLancamento().getTime()));
					pst.setInt(7, filme.getGenero().getId());			
					pst.execute();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		return filme.getId();
		}

	public int excluirFilme(Filme filme) {
		String sqlDelete = "DELETE FROM filme WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
				pst.setInt(1, filme.getId());
				pst.execute();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filme.getId();
	}
	
	public Filme buscarFilme(int id) throws IOException{
		Filme filme = new Filme();
		filme.setId(id);
		
		String sqlSelect = "select titulo, descricao, diretor, posterpath, popularidade, data_lancamento, id_genero from filme where filme.id=?";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sqlSelect);){
		
			pst.setInt(1, filme.getId());
			
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					filme.setTitulo(rs.getString("titulo"));
					filme.setDescricao(rs.getString("descricao"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setPosterPath(rs.getString("posterpath"));
					filme.setPopularidade(rs.getDouble("popularidade"));
					filme.setDataLancamento(rs.getDate("dataLancamento"));
				} else {
					filme.setTitulo(null);
					filme.setDescricao(null);
					filme.setDiretor(null);
					filme.setPosterPath(null);
					filme.setPopularidade(0);
					filme.setDataLancamento(null);

					}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return filme;
	}
		
	}
	

