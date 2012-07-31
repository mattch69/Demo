package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formats.NonEmpty;
import play.data.validation.Constraints.Required;


import play.db.ebean.Model;

@Entity 
public class Utilisateur extends Model{
	
	@Id
    @Required
    @NonEmpty
	@Column(name = "nom")
    public String nom;
    
	@Column(name = "prenom")
    public String prenom;
    
	@Column(name = "points")
    public Integer points;
    
	@Required
	@NonEmpty
	@Column(name = "password")
    public String password;
    
    public static Finder<Long,Utilisateur> find = new Finder<Long,Utilisateur>(Long.class, Utilisateur.class); 

    public static Utilisateur findByNom(String nom) {
        return find.where().eq("nom", nom).findUnique();
    }
    
    public static Utilisateur authenticate(String login, String password) {
        return find.where()
            .eq("nom", login)
            //.eq("password", password)
            .findUnique();
    }
    
    public String toString() {
        return "User(" + nom + ")";
    }

}
