package dao.bdr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Uf;

public class UfDao extends Dao<Uf> {

	private Uf r2o(ResultSet resultSet) {
		Uf uf = null;
		try {
			uf = new Uf();
			uf.setId(resultSet.getInt("id"));
			uf.setNome(resultSet.getString("nome"));
			uf.setSigla(resultSet.getString("sigla"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uf;
	}

	@Override
	public void criar(Uf object) {
		try {
			String sql = String.format( //
					"insert into %s.uf (id, nome, sigla) values (?, ?, ?)", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());
			preparedStatement.setString(2, object.getNome());
			preparedStatement.setString(3, object.getSigla());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Uf ler(Uf object) {
		Uf uf = null;
		try {
			String sql = String.format( //
					"select id, nome, sigla from %s.uf where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				uf = r2o(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uf;
	}

	@Override
	public List<Uf> lerTodos() {
		List<Uf> ufs = new ArrayList<Uf>();
		try {
			String sql = String.format( //
					"select id, nome, sigla from %s.uf", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Uf uf = r2o(resultSet);
				ufs.add(uf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ufs;
	}

	@Override
	public void atualizar(Uf object) {
		try {
			String sql = String.format( //
					"update %s.uf set nome = ?, sigla = ? where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, object.getNome());
			preparedStatement.setString(2, object.getSigla());
			preparedStatement.setInt(3, object.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Uf object) {
		try {
			String sql = String.format( //
					"delete from %s.uf where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
