package models.repositorios;

import java.util.List;

import models.entity.Voluntario;

public interface IRepVoluntario {
	public List<Voluntario> all();
	
	public Voluntario findId(long id);
	
	public void cadastrar(Voluntario voluntario);
	
	public void remover(long id);
	
	public void atualizar(Voluntario voluntario, Long id);
}