package controllers;

import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.index;

@Authenticated(Secured.class)
public class Application extends Controller {

  
	  public static Result index() {
	
		  return ok(index.render(Utilisateur.findByNom(request().username())));
		  
	  }
  
  
}