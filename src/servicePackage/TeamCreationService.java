/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.TeamLoginTable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chetan
 */
public class TeamCreationService {
    private TeamLoginTable teamEntry;
    private EntityManager manager;
    private TypedQuery<String> teamUsernameQuery;
    public TeamCreationService(EntityManager manager){
        this.manager = manager;
    }
    public boolean checkTeamUsernameExistence(String teamUsername){
        
        boolean valid=false;
        teamUsernameQuery = manager.createQuery("SELECT t.teamUsername FROM TeamLoginTable t WHERE t.teamUsername = :teamUsername", String.class);
        teamUsernameQuery.setParameter("teamUsername", teamUsername);
        String result = teamUsernameQuery.getSingleResult();
        System.out.println(result);
        //if(result!=null)
          //  valid = false;
        return true;
        
    }
    public TeamLoginTable createTeam(String teamUsername, String password, String teamName, String role){
        teamEntry = new TeamLoginTable();
        teamEntry.setTeamUsername(teamUsername);
        teamEntry.setTeamPassword(password);
        teamEntry.setTeamName(teamName);
        teamEntry.setRole(role);
        manager.persist(teamEntry);
        return teamEntry;
    }
}
