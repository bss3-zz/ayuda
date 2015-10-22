package models.entity;

import javax.persistence.*;

import models.entity.Usuario;
import com.avaje.ebean.Model;
import play.data.validation.Constraints.Required;

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
	@OneToOne() 
	public Usuario usuario;

	/**
     * Generic query helper para entidade ONG com id Long
     */
	public static Finder<Long,ONG> find = new Finder<Long,ONG>(Long.class, ONG.class); 
}