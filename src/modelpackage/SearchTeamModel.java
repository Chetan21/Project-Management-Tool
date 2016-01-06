/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.TeamLoginTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import servicePackage.SearchTeamsService;

/**
 *
 * @author Chetan
 */
public class SearchTeamModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private TeamLoginTable teamTable;
    private SearchTeamsService searchTeamsService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    private List<TeamLoginTable> teams;
    
    public SearchTeamModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        teamTable = new TeamLoginTable();
        searchTeamsService = new SearchTeamsService(manager);
    }
    
    public List<TeamLoginTable> retrieveNames(){
        
        teams = searchTeamsService.fetchTeamNames();
        
        return teams;
        
    }
}
