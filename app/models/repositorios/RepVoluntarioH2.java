package models.repositorios;

import java.util.Iterator;
import java.util.List;

import models.entity.Usuario;
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

	@Override
	public Voluntario pegarVoluntarioAssociado(Usuario usuario) {
		List<Voluntario> voluntarios  = all();
		Iterator<Voluntario> it = voluntarios.iterator();
		
		while (it.hasNext()) {
			Voluntario temp = it.next();
			System.err.println(temp.toString());
			if (temp.usuario.getId() == usuario.id) return temp;
		}
		
		return null;
		
	}

}

