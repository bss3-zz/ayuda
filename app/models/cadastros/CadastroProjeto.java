package models.cadastros;

import java.io.FileNotFoundException;

import models.entity.Projeto;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepProjeto;

public class CadastroProjeto {
	private IRepProjeto repProjeto;
	
	
	public CadastroProjeto() throws FileNotFoundException {
		repProjeto = FabricaRepositorio.criarFabricaRep().criarRepProjeto();
	}


	public void cadastrar(Projeto projeto) {
		repProjeto.cadastrar(projeto);
	}
	
	public void remover(Long id){
		repProjeto.remover(id);
	}
	
	public void atualizar(Projeto projeto) {
		repProjeto.atualizar(projeto, projeto.id);
	}
}