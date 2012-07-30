package controllers;

import java.util.List;

import com.avaje.ebean.Page;

import models.Equipe;
import models.Match;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.pronosticsForm;

public class Application extends Controller {
  
  public static Result index() {

	  return ok(index.render());
	  
  }
  
  public static Result pronostics() {
	  List<Match> matches = Match.find.all();
      return ok(
          pronosticsForm.render(matches)
      );
  }

}