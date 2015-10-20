package models;

import models.controlador.ControladorUsuario;
import models.controlador.ControladorVoluntario;
import models.entity.Usuario;

public class Fachada {
	private static final Fachada fachada = new Fachada();
	public static final ControladorUsuario CONTROLADOR_USUARIO = new ControladorUsuario();
	public static final ControladorVoluntario CONTROLADOR_VOLUNTARIO = new ControladorVoluntario();
	
	private Fachada(){
		//Contrutor criado pra evitar instanciacao desta classe.
	}
	
	public static Fachada getInstance(){
		return fachada;
	}
}
