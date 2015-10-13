package models.fabricaRepositorio;

import models.repositorios.IRepVoluntario;
import models.repositorios.IRepONG;
import models.repositorios.IRepUsuario;
import models.repositorios.IRepProjeto;


public interface IFabricaRepositorio {
	public IRepONG criarRepONG();
	public IRepVoluntario criarRepVoluntario();
	public IRepUsuario criarRepUsuario();
	public IRepProjeto criarRepProjeto();
}