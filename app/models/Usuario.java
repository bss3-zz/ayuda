package models;

import javax.persistence.*;
import java.security.MessageDigest;

import play.db.ebean.*;
import play.data.validation.Constraints.Required

@Entity
public class Usuario extends Model{
    private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String usuario;
	
	@Required
	public String senha;
	
	public String getDigest(String senha){
	    if (senha == null || senha.lenght){
	        throw new IllegalArgumentException("O campo de senha naão pode ser vazio");
	    }
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(senha.getBytes());
	    return new String(messageDigest.digest());
	}
	
	public void alterarSenha(String novaSenha){
	   
	   this.senha = getDigest(novaSenha);
	}
	
	public boolean authenticate(String usuario, String senha){
	    senhaPassada = getDigest(senha)
	    return this.usuario.equals(usuario) && this.verificarSenha(senha);
	}
	
	public boolean verificarSenha(String senha){
	    return this.senha.equals(getDigest(senha));
	}
	
}


