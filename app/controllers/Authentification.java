package controllers;

import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

public class Authentification extends Controller {

    public static class AuthenticatedUtilisateur {

        public String nom;
        public String password;

        public String validate() {
            if(Utilisateur.authenticate(nom, password) == null) {
            	
                return "Informations incorrecte"+nom+" "+password;
            }
            return null;
        }
    }

    public static Result login() {
        return ok(
            login.render(form(AuthenticatedUtilisateur.class))
        );
    }


    public static Result authenticate() {
        Form<AuthenticatedUtilisateur> loginForm = form(AuthenticatedUtilisateur.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("nom", loginForm.get().nom);
            return redirect(
                routes.Application.index()
            );
        }
    }

    //Fermer la session
    public static Result logout() {
        session().clear();
        flash("success", "Vous êtes déconnecté(e)");
        return redirect(
            routes.Authentification.login()
        );
    }

}
