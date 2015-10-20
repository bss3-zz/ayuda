package models.entity;

import javax.persistence.*;

import models.entity.Usuario;
import play.db.ebean.*;
import play.data.validation.Constraints.Required;

import java.util.Date;

@Entity
public class Projeto extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	
	@Required
	public String objetivo;
	
	@Required
	public String valorArrecadar;
	
	@Required
	public Date dataInicio;
	
	@Required
	public Date dataFim;
	
	@Required
	public String urlFoto;
	
	@Required
	public String urlVideo;
	
	@Required
	public String descricaoCompleta;

	/**
     * Generic query helper para entidade Projeto com id Long
     */
	public static Finder<Long,Projeto> find = new Finder<Long,Projeto>(Long.class, Projeto.class); 
}