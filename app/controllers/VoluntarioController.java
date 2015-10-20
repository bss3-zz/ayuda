package controllers;
 
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.Fachada;
import models.entity.Usuario;
import models.entity.Voluntario;
import play.mvc.*;
import play.mvc.Controller;
import play.data.Form;
import views.html.cadastro;
import views.html.info_usuario;

 public class VoluntarioController extends Controller {
 
	 public Result loadPage(){
		 return ok(info_usuario.render());
	 }
	 
     public Result show (Long id) {
         Usuario usuario = Fachada.getInstance().CONTROLADOR_USUARIO.show(id);
         return ok(info_usuario.render());
     }
 
     public Result registrar() {
    	 Form<Usuario> formUsuario = Form.form(Usuario.class);
    	 Usuario usuario = formUsuario.bindFromRequest().get();
    	 boolean sucess = false;
    	 
    	 if (usuario != null){
    		 boolean result = Fachada.CONTROLADOR_USUARIO.cadastroUsuario(usuario);
    		 if (result){
    			 Map<String, String[]> formBody = request().body().asFormUrlEncoded();
    			 Voluntario voluntario = new Voluntario();
    			 voluntario.setNome( formBody.get("nome").toString());
    			 voluntario.setCPF( formBody.get("CPF").toString());
    			 voluntario.setTelefone(formBody.get("nome").toString());
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
 
