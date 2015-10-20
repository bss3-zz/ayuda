package models.controlador;

import java.io.FileNotFoundException;

import models.cadastros.CadastroVoluntario;
import models.entity.Voluntario;

public class ControladorVoluntario {
	public CadastroVoluntario cadastroVoluntario;
	
	public ControladorVoluntario() {
		try {
			this.cadastroVoluntario = new CadastroVoluntario();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean cadastrarVoluntario(Voluntario voluntario){
		cadastroVoluntario.cadastrar(voluntario);
		return voluntario.id!=0;
	}
}
