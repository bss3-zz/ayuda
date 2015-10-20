package models.cadastros;

import java.io.FileNotFoundException;

import models.ONG;
import models.fabricaRepositorio.FabricaRepositorio;
import models.repositorios.IRepONG;

public class CadastroONG {
	private IRepONG repONG;
	
	
	public CadastroONG() throws FileNotFoundException {
		repONG = FabricaRepositorio.criarFabricaRep().criarRepONG();
	}


	public void cadastrar(ONG ong) {
		repONG.cadastrar(ong);
	}
	
	public void remover(Long id){
		repONG.remover(id);
	}
	
	public void atualizar(ONG ong) {
		repONG.atualizar(ong, ong.id);
	}
}