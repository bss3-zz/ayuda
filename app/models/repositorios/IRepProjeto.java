package models.repositorios;

import java.util.List;

import models.entity.Projeto;

public interface IRepProjeto {
	public List<Projeto> all();
	
	public Projeto findId(long id);
	
	public void cadastrar(Projeto projeto);
	
	public void remover(long id);
	
	public void atualizar(Projeto projeto, Long id);
}