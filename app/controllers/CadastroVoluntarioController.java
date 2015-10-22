package controllers;
 
import java.util.Map;

import models.Fachada;
import models.entity.Usuario;
import models.entity.Voluntario;
import play.mvc.*;
import play.mvc.Controller;
import play.data.Form;
import views.html.cadastro;

 public class CadastroVoluntarioController extends Controller {
	 
     public Result registrar() {
    	 Form<Usuario> formUsuario = Form.form(Usuario.class);
    	 Usuario usuario = formUsuario.bindFromRequest().get();
    	 boolean sucess = false;
    	 
    	 if (usuario != null){
    		 boolean result = Fachada.CONTROLADOR_USUARIO.cadastroUsuario(usuario);
    		 if (result){
    			 Map<String, String[]> formBody = request().body().asFormUrlEncoded();
    			 Voluntario voluntario = new Voluntario();
    			 voluntario.setNome( formBody.get("nome")[0]);
    			 voluntario.setCPF( formBody.get("CPF")[0]);
    			 voluntario.setTelefone(formBody.get("telefone")[0]);
    			 voluntario.setUsuario(usuario);			 
    			 Form<Voluntario> formVoluntario = Form.form(Voluntario.class, Usuario.class);
    			 formVoluntario.fill(voluntario);
    			 
    			 boolean result1 = Fachada.CONTROLADOR_VOLUNTARIO.cadastrarVoluntario(voluntario);
    			 sucess = result1;
    			 
    			 if (!result1){ //Precisamos deletar o usario criado pois
    				 Fachada.CONTROLADOR_USUARIO.cadastroUsuario.remover(usuario.id);
    			 }
    		 }else{
    			 return ok(cadastro.render(true, "Usuário já cadastrado no sistema"));
    		 }
    	 }
    	 
    	 if (sucess){
    	     return ok(cadastro.render(true, "Voluntário criado com sucesso!"));
    	 }else{
    		 return ok(cadastro.render(true, "Falha ao criar criado com sucesso!"));
    	 }
     }
 }
 
