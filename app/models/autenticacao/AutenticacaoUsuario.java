package models.autenticacao;

import java.io.FileNotFoundException;

import models.entity.Usuario;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepUsuario;

public class AutenticacaoUsuario {
	private IRepUsuario repONG;
	
	public AutenticacaoUsuario() throws FileNotFoundException {
		repONG = FabricaRepositorio.criarFabricaRep().criarRepUsuario();
	}
	
	public Usuario autenticar(String usuario, String senha){
		Usuario q_usuario = repONG.findByUsername(usuario);
		
		if(q_usuario == null) return null;
		else{
			if(q_usuario.verificarSenha(senha)) return q_usuario;
			else return null;
		}
	}
}
