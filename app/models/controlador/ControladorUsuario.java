package models.controlador;

import java.io.FileNotFoundException;

import models.cadastros.CadastroUsuario;
import models.entity.Usuario;
import views.html.cadastro;

public class ControladorUsuario {
	public CadastroUsuario cadastroUsuario;
	
	public ControladorUsuario() {
		try {
			this.cadastroUsuario = new CadastroUsuario();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean cadastroUsuario(Usuario usuario){
		System.err.println("Passou aqui 1");
		if (!cadastroUsuario.verificarUsername(usuario)){
			System.err.println("Passou aqui 2");
			cadastroUsuario.cadastrar(usuario);
			return true;
		}else{
			return false;
		}
	}
	
	public Usuario show(Long id){
		return cadastroUsuario.pegarUsuario(id);
	}
}
