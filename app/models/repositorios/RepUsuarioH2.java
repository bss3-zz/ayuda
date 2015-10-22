package models.repositorios;

import java.util.Iterator;
import java.util.List;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.QueryIterator;

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
	
	public Usuario findByUsername(String username){
		ExpressionList<Usuario> query = Usuario.find.where().ilike("usuario", username);
		QueryIterator<Usuario> it = query.findIterate();
		Usuario usuario = null;
		int count = 0;
		while(it.hasNext()){
			count++;
			usuario = it.next();
		}
		
		if (count > 1) return null;
		else return usuario;
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

