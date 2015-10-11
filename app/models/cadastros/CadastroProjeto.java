package models.cadastros;

import models.Projeto;
import models.FabricaRep.FabricaRep;
import models.Repositorios.IRepTreinamento;

public class CadastroTreinamento {
	private IRepTreinamento repTreinamento;
	
	
	public CadastroTreinamento() {
		repTreinamento = FabricaRep.criarFabricaRep().createRepTreinamento();
	}


	public void cadastrar(Treinamento treinamento) {
		treinamento.aprovado = false;
		repTreinamento.cadastrar(treinamento);
	}
	
	public void remover(Long id){
		repTreinamento.remover(id);
	}
	
	public void atualizar(Treinamento treinamento) {
		repTreinamento.atualizar(treinamento, treinamento.id);
	}
}