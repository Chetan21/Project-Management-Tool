/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.TeamLoginTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chetan
 */
public class SearchTeamsService {
    
    private TypedQuery<TeamLoginTable> teamNamesQuery;
    private EntityManager manager;
    private List<TeamLoginTable> teamNames;
    
    public SearchTeamsService(EntityManager manager){
        this.manager = manager;
    }
    public List<TeamLoginTable> fetchTeamNames(){
        
        teamNamesQuery = manager.createQuery("SELECT t FROM TeamLoginTable t WHERE t.teamName IS NOT NULL", TeamLoginTable.class);
        //teamNamesQuery.setParameter("val", "");
        teamNames = teamNamesQuery.getResultList();
        
        return teamNames;
    }
}
