package models.repositorios;

import java.util.List;

import models.ONG;

public interface IRepONG {
	public List<ONG> all();
	
	public ONG findId(long id);
	
	public void cadastrar(ONG ong);
	
	public void remover(long id);
	
	public void atualizar(ONG ong, Long id);
}