package models.repositorios;

import java.util.List;

import models.Usuario;


public class RepUsuarioH2 implements IRepUsuario{
	@Override
	public List<Usuario> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrar(Usuario usuario) {
		usuario.save();
	}

	@Override
	public void remover(long id) {
		Usuario.find.ref(id).delete();
	}

	@Override
	public void atualizar(Usuario usuario, Long id) {
		usuario.update(id);
	}

}

