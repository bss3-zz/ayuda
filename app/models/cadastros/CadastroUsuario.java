package models.cadastros;

import java.io.FileNotFoundException;

import models.Usuario;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepUsuario;

public class CadastroUsuario {
	private IRepUsuario repUsuario;
	
	
	public CadastroUsuario() throws FileNotFoundException {
		repUsuario = FabricaRepositorio.criarFabricaRep().criarRepUsuario();
	}


	public void cadastrar(Usuario usuario) {
		repUsuario.cadastrar(usuario);
	}
	
	public void remover(Long id){
		repUsuario.remover(id);
	}
	
	public void atualizar(Usuario usuario) {
		repUsuario.atualizar(usuario, usuario.id);
	}
}