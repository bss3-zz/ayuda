package models;

import models.controlador.ControladorUsuario;
import models.entity.Usuario;

public class Fachada {
//	private static Fachada fachada;
	public static ControladorUsuario controladorUsuario = new ControladorUsuario();

	public static boolean cadastrarUsuario(Usuario usuario) {
		return controladorUsuario.cadastroUsuario(usuario);
	}
	
//	public static Fachada getInstance(){
//		return fachada;
//	}
}
