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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.TeamCreationService;

/**
 *
 * @author Chetan
 */
public class TeamCreationModel {
    private List<TeamLoginTable> teamLoginList;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private TeamLoginTable teamTable;
    private TeamCreationService teamService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public TeamCreationModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        teamService = new TeamCreationService(manager);
        teamTable = new TeamLoginTable();
        //teamLoginList = new TeamLoginTable();
    }
    
    public boolean addTeam(String[] a){
        boolean valid = teamService.checkTeamUsernameExistence(a[2]);
        if(valid == false){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        TeamLoginTable newRecord = teamService.createTeam(a[0],a[1],a[2],a[3]);
        userTransaction.commit();
        }
        else 
            valid = false;
        return valid;
    }
   
}
