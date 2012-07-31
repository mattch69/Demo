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
		Utilisateur user = Utilisateur.findByNom(request().username());
		List<Match> matches = Match.find.all();
		//List<Pronostique> pronostiques = Pronostique.find.where().eq("utilisateur",user).in("match", matches).findList();
		List<Pronostique> pronostiques = Pronostique.find.all();
		pronostiqueForm = form(Pronostique.class);
		return ok(
		pronosticsForm.render(matches,pronostiques,pronostiqueForm,user)
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
