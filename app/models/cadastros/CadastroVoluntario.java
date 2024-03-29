package models.cadastros;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import models.entity.Usuario;
import models.entity.Voluntario;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepVoluntario;

public class CadastroVoluntario {
	private IRepVoluntario repVoluntario;
	
	
	public CadastroVoluntario() throws FileNotFoundException {
		repVoluntario = FabricaRepositorio.criarFabricaRep().criarRepVoluntario();
	}


	public void cadastrar(Voluntario voluntario) {
		repVoluntario.cadastrar(voluntario);
	}
	
	public void remover(Long id){
		repVoluntario.remover(id);
	}
	
	public void atualizar(Voluntario voluntario) {
		repVoluntario.atualizar(voluntario, voluntario.id);
	}
	
	public Voluntario pegarVoluntario(Long id){
		return repVoluntario.findId(id);
	}
	
	public Voluntario pegarVoluntarioAssociado(Usuario usuario){
		return repVoluntario.pegarVoluntarioAssociado(usuario);
	}
}