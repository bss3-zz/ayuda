package controllers;

import models.Fachada;
import models.entity.Voluntario;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.info_usuario;
import views.html.perfil_usuario;

public class VoluntarioPerfilController extends Controller{
	public Result loadPage(){
		String user_type = session().get("user_type");
		if (user_type != null && user_type.equals("VOLUNTARIO")){
			String voluntario_id = session().get("voluntario_id");
			if(voluntario_id != null){
				long id = Long.parseLong(voluntario_id);
				Voluntario voluntario = Fachada.CONTROLADOR_VOLUNTARIO.show(id);
				return ok(perfil_usuario.render(voluntario));
			}else{
				return redirect(routes.Application.login());
			}
		}else{
			return redirect(routes.Application.login());
		}
	}
}
