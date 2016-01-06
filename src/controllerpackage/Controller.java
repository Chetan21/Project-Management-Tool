/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerpackage;

import modelpackage.TeamCreationModel;
import modelpackage.LoginModel;

import GUIpackage.UserGUI;
import entityClassesPackage.BudgetTable;
import entityClassesPackage.CommunicationTable;
import entityClassesPackage.MemberDetailsTable;
import entityClassesPackage.ProjectDetailsTable;
import entityClassesPackage.TaskTable;
import entityClassesPackage.TeamLoginTable;
import java.util.List;
//import modelpackage.TableModelExample;
import modelpackage.BudgetTableModel;
import modelpackage.ProjectModel;
import modelpackage.TaskModel;
import modelpackage.AddingMemberToTeamModel;
import modelpackage.CommunicationsTableModel;
import modelpackage.MemberCreationModel;
import modelpackage.MemberDeletionModel;
import modelpackage.ProjectDeletionModel;
import modelpackage.SearchMembersModel;
import modelpackage.SearchProjectsModel;
import modelpackage.SearchTeamModel;

/**
 *
 * @author Chetan
 */
public class Controller  {
    private TeamCreationModel teamModel;
    private LoginModel loginModel;
    private MemberCreationModel memberModel;
    private SearchMembersModel searchMembersModel;
    private SearchProjectsModel searchProjectsModel;
    private SearchTeamModel searchTeamModel;
    private AddingMemberToTeamModel memberToTeamModel;
    private List<MemberDetailsTable> memberDetails;
    private List<ProjectDetailsTable> projectDetails;
    private List<TeamLoginTable> teamDetails;
    private List<CommunicationTable> commDetails;
    private List<BudgetTable> budgetDetails;
    private List<TaskTable> taskDetails;
    private MemberDeletionModel memberDeletionModel;
    private ProjectDeletionModel projectDeletionModel;
    //private TableModelExample tableModel;
    private BudgetTableModel budgetModel;
    private UserGUI gui;
    private ProjectModel projectModel;
    private TaskModel taskModel;
    private CommunicationsTableModel commTableModel;
    
    public Controller(){
        teamModel = new TeamCreationModel();
        loginModel = new LoginModel();
        memberModel = new MemberCreationModel();
        searchMembersModel = new SearchMembersModel();
        searchProjectsModel = new SearchProjectsModel();        
        searchTeamModel = new SearchTeamModel();
        memberToTeamModel = new AddingMemberToTeamModel();
        memberDeletionModel = new MemberDeletionModel();
        projectDeletionModel = new ProjectDeletionModel();
        projectModel = new ProjectModel();
        taskModel = new TaskModel();
        commTableModel = new CommunicationsTableModel();
        budgetModel = new BudgetTableModel();
    }
    public boolean addTeam(String[] a){
        
        boolean duplicateTeam = teamModel.addTeam(a);
        return duplicateTeam;
    }
    public String checkLogin(String[] a){
        String isValid = loginModel.checkLogin(a);
        return isValid;
    }
    
    public void addProject(String[] a){
       projectModel.addProject(a);
    }
    
    public void addTask(Object[] a){
        taskModel.addTask(a);
    }

    public boolean addMember(String[] memberInput){
        boolean success = false;
        success = memberModel.addMember(memberInput);
        return success;
    }
    
    public List<MemberDetailsTable> retrieveAllMembers(){
        memberDetails = searchMembersModel.retrieveNames();
        return memberDetails;
    }
    
    public List<MemberDetailsTable> searchMemberDetail(String memberEmail){
        memberDetails = searchMembersModel.retrieveMemberInformation(memberEmail);
        return memberDetails;
    }
    
    public List<ProjectDetailsTable> retrieveAllProjects(){
        projectDetails = searchProjectsModel.retrieveProjects();
        return projectDetails;
    }
    
    public List<TeamLoginTable> retrieveAllTeams(){
        teamDetails = searchTeamModel.retrieveNames();
        return teamDetails;
    }
    public boolean addMemberToTeam(String team, String member){
        boolean valid = false;
        valid = memberToTeamModel.addMemberToTeam(team, member);
        return valid;
    
    }
    public void adminPasswordChange(String username, String password){
        
    }
    
    public void deleteMember(String memberEmail){
        memberDeletionModel.deleteMember(memberEmail);
    }
    
    public void deleteProject(ProjectDetailsTable project){
        projectDeletionModel.deleteProject(project);
    }
    
    public void addBudgetRow(Object[] array)
    {
	budgetModel.addBudgetRow(array);
    }
    
    public void deleteRow(int delItem)
    {
	budgetModel.deleteRow(delItem);
    }
    
    public void updateRow(String[] array)
    {
        budgetModel.updateRow(array);
      
    }
    
    public void addCommunicationRow(Object[] array)
    {
	commTableModel.addCommunicationRow(array);
    }
    
    public List<CommunicationTable> retrieveCommunications(){
        commDetails = commTableModel.retrieveCommunications();
        return commDetails;
    }
    
    public List<BudgetTable> retrieveBudget(){
        budgetDetails = budgetModel.retrieveBudget();
        return budgetDetails;
    }
    
    public List<TaskTable> retrieveTasks(){
        taskDetails = taskModel.retrieveTasks();
        return taskDetails;
    }
}
