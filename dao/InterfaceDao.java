package dao;

import java.util.List;

public interface InterfaceDao<T> {
	
	public void criar(T object);
	
	public T ler(T object);
	
	public List<T> lerTodos();
	
	public void atualizar(T object);
	
	public void excluir(T object);	

}
