package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity 
public class Match extends Model{
	
	@Id
    public Long id;

	@ManyToOne
    @JoinColumn(name="Equipe1")
    public Equipe equipe1;
    
    @ManyToOne
    @JoinColumn(name="Equipe2")
    public Equipe equipe2;
    
    @Column(name="scoreEquipe1")
    public Integer scoreEquipe1;
    
    @Column(name="scoreEquipe2")
    public Integer scoreEquipe2;
    
    @ManyToOne
    @JoinColumn(name="vainqueur")
    public Equipe vainqueur;
    
    public static Finder<Long,Match> find = new Finder<Long,Match>(Long.class, Match.class); 

    public static Match findById(Long id) {
        return find.byId(id);
    }
    
    /**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page<Match> page(int page, int pageSize) {
        return 
            find.where().findPagingList(pageSize)
                .getPage(page);
    }
    
    

}
