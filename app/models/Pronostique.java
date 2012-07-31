package models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

public class Pronostique extends Model {

	@Id
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="match")
	private Match match;
	
	@ManyToOne
    @JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	
	@Required
	private Integer pronoEquipe1;
	@Required
	private Integer pronoEquipe2;
	
	public static Finder<Long,Pronostique> find = new Finder(
		    Long.class, Pronostique.class
		  );
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Integer getPronoEquipe1() {
		return pronoEquipe1;
	}
	public void setPronoEquipe1(Integer pronoEquipe1) {
		this.pronoEquipe1 = pronoEquipe1;
	}
	public Integer getPronoEquipe2() {
		return pronoEquipe2;
	}
	public void setPronoEquipe2(Integer pronoEquipe2) {
		this.pronoEquipe2 = pronoEquipe2;
	}
	
	public static void create(Pronostique pronostique){
		pronostique.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	
}
