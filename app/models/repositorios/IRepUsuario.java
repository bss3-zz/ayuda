package models.repositorios;

import java.util.List;

import models.entity.Usuario;

public interface IRepUsuario {
	public List<Usuario> all();
	
	public Usuario findId(long id);
	
	public Usuario findByUsername(String username);
	
	public void cadastrar(Usuario usuario);
	
	public void remover(long id);
	
	public void atualizar(Usuario usuario, Long id);
	
	public boolean verificarUsuario(Usuario usuario);
}