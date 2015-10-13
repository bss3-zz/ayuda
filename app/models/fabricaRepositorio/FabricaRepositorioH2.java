package models.fabricaRepositorio;

import models.repositorios.IRepUsuario;
import models.repositorios.RepUsuarioH2;
import models.repositorios.IRepONG;
import models.repositorios.RepONGH2;
import models.repositorios.IRepProjeto;
import models.repositorios.RepProjetoH2;
import models.repositorios.IRepVoluntario;
import models.repositorios.RepVoluntarioH2;

public class FabricaRepositorioH2 implements IFabricaRepositorio{
	
	@Override
	public IRepVoluntario criarRepVoluntario() {
		return new RepVoluntarioH2();
	}

	@Override
	public IRepONG criarRepONG() {
		// TODO Auto-generated method stub
		return new RepONGH2();
	}

	@Override
	public IRepUsuario criarRepUsuario() {
		// TODO Auto-generated method stub
		return new RepUsuarioH2();
	}

	@Override
	public IRepProjeto criarRepProjeto() {
		// TODO Auto-generated method stub
		return new RepProjetoH2();
	}

}