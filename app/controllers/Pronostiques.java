package controllers;

import java.util.List;

import models.Match;
import models.Pronostique;
import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.pronosticsForm;

@Authenticated(Secured.class)
public class Pronostiques extends Controller  {

	static Form<Pronostique> pronostiqueForm = form(Pronostique.class);
	
	public static Result pronostics() {
		List<Match> matches = Match.find.all();
		pronostiqueForm = form(Pronostique.class);
		return ok(
		pronosticsForm.render(matches,pronostiqueForm,Utilisateur.findByNom(request().username()))
		);
	}
  
	public static Result add() {
		Form<Pronostique> filledForm = pronostiqueForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(Utilisateur.findByNom(request().username()))
			);
		} else {
			Pronostique.create(filledForm.get());
			return redirect(routes.Pronostiques.pronostics());  
		}
	}
	  
	public static Result deletePronostique(Long id) {
		return TODO;
	}

}
