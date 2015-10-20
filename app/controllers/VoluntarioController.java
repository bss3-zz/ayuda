package controllers;
 
import java.util.Map;

import models.Fachada;
import models.entity.Usuario;
import models.entity.Voluntario;
import play.mvc.*;
import play.mvc.Controller;
import play.data.Form;
import views.html.info_usuario;

 public class VoluntarioController extends Controller {
 
	 public Result loadPage(){
		 return ok(info_usuario.render());
	 }
	 
     public Result show (Long id) {
    	 Fachada fachada = new Fachada();
         Usuario usuario = Fachada.controladorUsuario.show(id);
         return ok(info_usuario.render());
     }
 
     public Result registrar() {
    	 Form<Usuario> formUsuario = Form.form(Usuario.class);
    	 Usuario usuario = formUsuario.bindFromRequest().get();
    	 
    	 if (usuario == null){
    		 Map<String, String[]> body = request().body().asFormUrlEncoded();
        	 return ok("Got body: " + body);
    	 }else{
    		 boolean result = Fachada.cadastrarUsuario(usuario);
    		 if (result){
    			 return ok("Usuario de ID: " + usuario.getId() + " salvo com sucesso.");
    		 }else{
    			 return ok("deu merda!");
    		 }
    	 }
     }
 
 }