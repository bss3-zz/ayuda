package models;

import javax.persistence.*;
import java.security.MessageDigest;

import play.db.ebean.Model;
import play.data.validation.Constraints.Required;

import java.security.NoSuchAlgorithmException;

@Entity
public class Usuario extends Model{
    private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String usuario;
	
	@Required
	public String senha;
	
	public String getDigest(String senha) throws NoSuchAlgorithmException{
	    if (senha == null || senha.length()==0){
	        throw new IllegalArgumentException("O campo de senha naão pode ser vazio");
	    }
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(senha.getBytes());
	    return new String(messageDigest.digest());
	}
	
	public void alterarSenha(String novaSenha) throws NoSuchAlgorithmException{
	   
	   this.senha = getDigest(novaSenha);
	}
	
	public boolean authenticate(String usuario, String senha) throws NoSuchAlgorithmException{
	    String senhaPassada = getDigest(senha);
	    return this.usuario.equals(usuario) && this.verificarSenha(senhaPassada);
	}
	
	public boolean verificarSenha(String senha) throws NoSuchAlgorithmException{
	    return this.senha.equals(getDigest(senha));
	}
	
	public static Finder<Long,Voluntario> find = new Finder<Long,Voluntario>(Long.class, Voluntario.class); 
}


