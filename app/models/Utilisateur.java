package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity 
public class Utilisateur extends Model{
	
	@Id
	private Long id;
    
	@Column(name = "nom")
    private String nom;
    
	@Column(name = "prenom")
    private String prenom;
    
	@Column(name = "points")
    private Integer points;
    
	@Column(name = "password")
    private String password;
	
	public Utilisateur(String nom, String prenom, Integer points, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.points = points;
		this.password = password;
	}
    
    public static Finder<Long,Utilisateur> find = new Finder<Long,Utilisateur>(Long.class, Utilisateur.class); 

    public static Utilisateur findById(Long id) {
        return find.byId(id);
    }

}
