package dao.bdr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Municipio;

public class MunicipioDao extends Dao<Municipio> {

	@Override
	public void criar(Municipio object) {
		try {			
			// 1 - Tratar a existência da UF na RN
			String sql = String.format( //
					"insert into %s.municipio (id, nome, id_uf) values (?, ?, ?)", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());
			preparedStatement.setString(2, object.getNome());
			preparedStatement.setInt(3, object.getUf().getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Municipio ler(Municipio object) {
		Municipio municipio = null;
		try {
			String sql = String.format( //
					"select id, nome, id_uf from %s.municipio where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// 1 - Criar método privado r2o
				// 2 - Tratar a carga do atributo municipio.uf na RN
				municipio = new Municipio();
				municipio.setId(resultSet.getInt("id"));
				municipio.setNome(resultSet.getString("nome"));
				municipio.getUf().setId(resultSet.getInt("id_uf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return municipio;
	}

	@Override
	public List<Municipio> lerTodos() {
		List<Municipio> municipios = new ArrayList<Municipio>();
		try {
			String sql = String.format( //
					"select id, nome, id_uf from %s.municipio", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// 1 - Criar método privado r2o
				// 2 - Tratar a carga do atributo municipio.uf na RN
				Municipio municipio = new Municipio();
				municipio.setId(resultSet.getInt("id"));
				municipio.setNome(resultSet.getString("nome"));
				municipio.getUf().setId(resultSet.getInt("id_uf"));
				
				municipios.add(municipio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return municipios;
	}

	@Override
	public void atualizar(Municipio object) {
		try {
			// 1 - Tratar a existência da UF na RN
			String sql = String.format( //
					"update %s.municipio set nome = ?, id_uf = ? where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, object.getNome());
			preparedStatement.setInt(2, object.getUf().getId());
			preparedStatement.setInt(3, object.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Municipio object) {
		try {
			// 1 - Tratar a existência da Pessoa na RN
			String sql = String.format( //
					"delete from %s.municipio where id = ?", //
					esquema);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
