package models.entity;

import javax.persistence.*;

import models.entity.Usuario;
import play.db.ebean.*;
import play.data.validation.Constraints.Required;

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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Generic query helper para entidade Voluntario com id Long
     */
	public static Finder<Long,Voluntario> find = new Finder<Long,Voluntario>(Long.class, Voluntario.class); 
}