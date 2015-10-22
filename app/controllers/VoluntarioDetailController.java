package controllers;

import models.Fachada;
import models.entity.Usuario;
import models.entity.Voluntario;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.info_usuario;
import views.html.perfil_usuario;

public class VoluntarioDetailController extends Controller{
	public Result loadPage(){
		String user_type = session().get("user_type");
		if (user_type != null && user_type.equals("VOLUNTARIO")){
			String voluntario_id = session().get("voluntario_id");
			String usuario_id = session().get("user_id");
			
			if(voluntario_id != null && usuario_id != null){
				long id_voluntario = Long.parseLong(voluntario_id);
				long id_usuario = Long.parseLong(usuario_id);
				Voluntario voluntario = Fachada.CONTROLADOR_VOLUNTARIO.show(id_voluntario);
				Usuario usuario = Fachada.CONTROLADOR_USUARIO.show(id_usuario);
				return ok(info_usuario.render(voluntario, usuario));
			}else{
				return redirect(routes.Application.login());
			}
		}else{
			return redirect(routes.Application.login());
		}
	}
	
	public Result edit(){
//		Voluntario voluntario = Fachada.CONTROLADOR_VOLUNTARIO.show(id);
		return null;
	}
}
