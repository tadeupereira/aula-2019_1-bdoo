package teste;

import java.util.List;

import dao.bdr.UfDao;
import entidade.Uf;

public class UfTeste {

	public static void main(String[] args) {
		Uf uf = new Uf();
		UfDao ufDao = new UfDao();

		// uf.setId(1);
		// uf.setNome("Ceará");
		// uf.setSigla("CE");
		// ufDao.criar(uf);
		//
		// uf.setId(2);
		// uf.setNome("Pernambuco");
		// uf.setSigla("PE");
		// ufDao.criar(uf);
		//
		// uf.setId(3);
		// uf.setNome("Bahia");
		// uf.setSigla("BA");
		// ufDao.criar(uf);

		// uf.setId(1);
		// uf = ufDao.ler(uf);
		// if (uf == null) {
		// System.out.println("Registro não localizado na tabela UF");
		// } else {
		// System.out.println("ID: " + uf.getId());
		// System.out.println("Nome: " + uf.getNome());
		// System.out.println("Sigla: " + uf.getSigla());
		// }

		// uf.setId(3);
		// uf.setNome("Paraíba");
		// uf.setSigla("PB");
		// ufDao.atualizar(uf);

		uf.setId(3);
		ufDao.excluir(uf);

		List<Uf> ufs = ufDao.lerTodos();
		if (ufs.size() == 0) {
			System.out.println("Tabela UF não tem registro");
		} else {
			for (Uf uf2 : ufs) {
				System.out.println("ID: " + uf2.getId());
				System.out.println("Nome: " + uf2.getNome());
				System.out.println("Sigla: " + uf2.getSigla());
			}
		}

		System.out.println("\nTeste concluído");

	}

}
