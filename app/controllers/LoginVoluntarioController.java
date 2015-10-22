package controllers;

import models.Fachada;
import models.entity.Usuario;
import models.entity.Voluntario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class LoginVoluntarioController extends Controller {
	public Result login() {
		Form<Usuario> formUsuario = Form.form(Usuario.class);
	   	Usuario usuario = formUsuario.bindFromRequest().get();
	   	Fachada.getInstance();
		usuario = Fachada.CONTROLADOR_USUARIO.login(usuario.usuario, usuario.senha);
	   	
	   	if(usuario!= null){
	   		Fachada.getInstance();
			Voluntario voluntario = Fachada.CONTROLADOR_VOLUNTARIO.cadastroVoluntario.pegarVoluntarioAssociado(usuario);
	   		session().clear();
	        session("user_id", usuario.getId()+"");
	        session("user_type", "VOLUNTARIO");
	        session("voluntario_id", voluntario.getId()+"");
	        return redirect(
	        	routes.VoluntarioPerfilController.loadPage()
		    );
	   	}else{
	        return redirect(
	            routes.Application.login()
	        );
	   	}
	}
}
