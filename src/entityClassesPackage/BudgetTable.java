/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "budget_table")
@NamedQueries({
    @NamedQuery(name = "BudgetTable.findAll", query = "SELECT b FROM BudgetTable b"),
    @NamedQuery(name = "BudgetTable.findByBudgetName", query = "SELECT b FROM BudgetTable b WHERE b.budgetName = :budgetName"),
    @NamedQuery(name = "BudgetTable.findByBudgetDesc", query = "SELECT b FROM BudgetTable b WHERE b.budgetDesc = :budgetDesc"),
    @NamedQuery(name = "BudgetTable.findByActualBudget", query = "SELECT b FROM BudgetTable b WHERE b.actualBudget = :actualBudget"),
    @NamedQuery(name = "BudgetTable.findByBudgetId", query = "SELECT b FROM BudgetTable b WHERE b.budgetId = :budgetId")})
public class BudgetTable implements Serializable {
    @Column(name = "estimated_budget")
    private Double estimatedBudget;
    private static final long serialVersionUID = 1L;
    @Column(name = "budget_name")
    private String budgetName;
    @Column(name = "budget_desc")
    private String budgetDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "actual_budget")
    private Double actualBudget;
    @Id
    @Basic(optional = false)
    @Column(name = "budget_id")
    private Integer budgetId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private ProjectDetailsTable projectId;

    public BudgetTable() {
    }

    public BudgetTable(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getBudgetDesc() {
        return budgetDesc;
    }

    public void setBudgetDesc(String budgetDesc) {
        this.budgetDesc = budgetDesc;
    }

    public Double getActualBudget() {
        return actualBudget;
    }

    public void setActualBudget(Double actualBudget) {
        this.actualBudget = actualBudget;
    }

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public ProjectDetailsTable getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectDetailsTable projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetId != null ? budgetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetTable)) {
            return false;
        }
        BudgetTable other = (BudgetTable) object;
        if ((this.budgetId == null && other.budgetId != null) || (this.budgetId != null && !this.budgetId.equals(other.budgetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.BudgetTable[ budgetId=" + budgetId + " ]";
    }

    public Double getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Double estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }
    
}
