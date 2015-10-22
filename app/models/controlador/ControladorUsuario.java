package models.controlador;

import java.io.FileNotFoundException;

import models.autenticacao.AutenticacaoUsuario;
import models.cadastros.CadastroUsuario;
import models.entity.Usuario;

public class ControladorUsuario {
	public CadastroUsuario cadastroUsuario;
	public AutenticacaoUsuario loginAuthenticator;
	
	public ControladorUsuario() {
		try {
			this.cadastroUsuario = new CadastroUsuario();
			this.loginAuthenticator = new AutenticacaoUsuario();
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
	
	public Usuario login(String usuario, String senha){
		return loginAuthenticator.autenticar(usuario, senha);
	}
}
