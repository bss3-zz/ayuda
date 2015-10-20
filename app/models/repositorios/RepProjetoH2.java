package models.repositorios;

import java.util.List;

import models.entity.Projeto;


public class RepProjetoH2 implements IRepProjeto{
	@Override
	public List<Projeto> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projeto findId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrar(Projeto projeto) {
		projeto.save();
	}

	@Override
	public void remover(long id) {
		Projeto.find.ref(id).delete();
	}

	@Override
	public void atualizar(Projeto projeto, Long id) {
		projeto.update(""+id);
	}

}

