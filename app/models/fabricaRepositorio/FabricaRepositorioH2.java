package models.fabricaRepositorio;

import models.repositorios.IRepUsuario;
import models.repositorios.RepUsuarioH2;
import models.repositorios.IRepONG;
import models.repositorios.RepONGH2;
import models.repositorios.IRepProjeto;
import models.repositorios.RepProjetoH2;
import models.repositorios.IRepVoluntario;
import models.repositorios.RepVoluntarioH2;

public class FabricaRepH2 implements IFabricaRepositorio{

	@Override
	public IRepUsuario createRepUsuario() {
		return new RepUsuarioH2();
	}
	
	@Override
	public IRepONG createRepONG() {
		return new RepONGH2();
	}
	
	@Override
	public IRepVoluntario createRepVoluntario() {
		return new RepVoluntarioH2();
	}
	
	@Override
	public IRepProjeto createRepProjeto() {
		return new RepProjetoH2();
	}

}