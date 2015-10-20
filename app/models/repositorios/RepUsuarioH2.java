package models.repositorios;

import java.util.Iterator;
import java.util.List;

import models.entity.Usuario;


public class RepUsuarioH2 implements IRepUsuario{
	@Override
	public List<Usuario> all() {
		return Usuario.find.all();
	}

	@Override
	public Usuario findId(long id) {
		return Usuario.find.byId(id);
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
		usuario.update(""+id);
	}

	public boolean verificarUsuario(Usuario usuario){
		boolean retorno = false;
		List<Usuario> usuarios = all();
		Iterator<Usuario> it = usuarios.iterator();
		
		while(it.hasNext()){
			Usuario usu = it.next();
			if (usu.verificarUsername(usuario.usuario)){
				retorno = true;
				break;
			}
		}
		
		return retorno;
	}
}

