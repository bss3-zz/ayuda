package models.cadastros;

import models.Projeto;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepProjeto;

public class CadastroProjeto {
	private IRepProjeto repProjeto;
	
	
	public CadastroProjeto() {
		repProjeto = FabricaRepositorio.criarFabricaRep().criarRepProjeto();
	}


	public void cadastrar(Projeto Projeto) {
		repProjeto.cadastrar(Projeto);
	}
	
	public void remover(Long id){
		repProjeto.remover(id);
	}
	
	public void atualizar(Projeto Projeto) {
		repProjeto.atualizar(Projeto, Projeto.id);
	}
}