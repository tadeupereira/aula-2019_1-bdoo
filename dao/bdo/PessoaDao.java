package dao.bdo;

import java.util.List;

import com.db4o.ObjectSet;

public class PessoaDao extends Dao<PessoaDao> {

	@Override
	public void criar(PessoaDao object) {
		objectContainer.store(object);
	}

	@Override
	public PessoaDao ler(PessoaDao object) {
		PessoaDao pessoa = null;

		ObjectSet<PessoaDao> pessoas = //
				objectContainer.queryByExample(object);

		if (pessoas.size() > 0) {
			pessoa = pessoas.get(0);
		}

		return pessoa;
	}

	@Override
	public List<PessoaDao> lerTodos() {
		ObjectSet<PessoaDao> pessoas = //
				objectContainer.queryByExample(new PessoaDao());
		return pessoas;
	}

	@Override
	public void atualizar(PessoaDao object) {
		// objectContainer.store(object);
		this.criar(object);
	}

	@Override
	public void excluir(PessoaDao object) {
		objectContainer.delete(object);
	}

}
