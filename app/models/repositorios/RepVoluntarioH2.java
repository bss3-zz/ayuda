package models.repositorios;

import java.util.List;

import models.entity.Voluntario;


public class RepVoluntarioH2 implements IRepVoluntario{
	@Override
	public List<Voluntario> all() {
		return Voluntario.find.all();
	}

	@Override
	public Voluntario findId(long id){
		return Voluntario.find.byId(id);
	}

	@Override
	public void cadastrar(Voluntario voluntario) {
		voluntario.save();
	}

	@Override
	public void remover(long id) {
		Voluntario.find.ref(id).delete();
	}

	@Override
	public void atualizar(Voluntario voluntario, Long id) {
		voluntario.update(""+id);
	}

}

