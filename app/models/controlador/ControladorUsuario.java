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
		if (!cadastroUsuario.verificarUsername(usuario)){
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
