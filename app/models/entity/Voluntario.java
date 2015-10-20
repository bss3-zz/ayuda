package models;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.Required;

import models.Usuario;

@Entity
public class Voluntario extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	
	@Required
	public String CPF;
	
	@Required
	public String telefone;
	
	@Required
	public Usuario usuario;

	/**
     * Generic query helper para entidade Voluntario com id Long
     */
	public static Finder<Long,Voluntario> find = new Finder<Long,Voluntario>(Long.class, Voluntario.class); 
}