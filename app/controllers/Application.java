package controllers;

import java.util.List;

import com.avaje.ebean.Page;

import models.Match;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
	  
	  List<Match> matches = Match.find.all();
	  return ok(index.render(matches));
	  
  } 

}