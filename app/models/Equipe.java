package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity 
public class Equipe extends Model{
	
	@Id
    public Long id;
    
    @Column(name = "nomEquipe")
    public String nom;
    
    public String getNom() {
    	return this.nom;
    }
    
    public static Finder<Long,Equipe> find = new Finder<Long,Equipe>(Long.class, Equipe.class); 

    public static Equipe findById(Long id) {
        return find.byId(id);
    }

}
