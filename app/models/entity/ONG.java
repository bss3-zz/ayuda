package models;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.Required;

import models.Usuario;

@Entity
public class ONG extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	
	@Required
	public String descricao;
	
	@Required
	public Usuario usuario;

	/**
     * Generic query helper para entidade ONG com id Long
     */
	public static Finder<Long,ONG> find = new Finder<Long,ONG>(Long.class, ONG.class); 
}