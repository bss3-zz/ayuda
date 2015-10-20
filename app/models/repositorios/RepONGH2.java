package models.repositorios;

import java.util.List;

import models.entity.ONG;


public class RepONGH2 implements IRepONG{
	@Override
	public List<ONG> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ONG findId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrar(ONG ong) {
		ong.save();
	}

	@Override
	public void remover(long id) {
		ONG.find.ref(id).delete();
	}

	@Override
	public void atualizar(ONG ong, Long id) {
		ong.update(""+id);
	}

}

