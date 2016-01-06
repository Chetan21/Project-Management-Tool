/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "role_table")
@NamedQueries({
    @NamedQuery(name = "RoleTable.findAll", query = "SELECT r FROM RoleTable r"),
    @NamedQuery(name = "RoleTable.findByRoleId", query = "SELECT r FROM RoleTable r WHERE r.roleTablePK.roleId = :roleId"),
    @NamedQuery(name = "RoleTable.findByRoleName", query = "SELECT r FROM RoleTable r WHERE r.roleTablePK.roleName = :roleName")})
public class RoleTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleTablePK roleTablePK;

    public RoleTable() {
    }

    public RoleTable(RoleTablePK roleTablePK) {
        this.roleTablePK = roleTablePK;
    }

    public RoleTable(int roleId, String roleName) {
        this.roleTablePK = new RoleTablePK(roleId, roleName);
    }

    public RoleTablePK getRoleTablePK() {
        return roleTablePK;
    }

    public void setRoleTablePK(RoleTablePK roleTablePK) {
        this.roleTablePK = roleTablePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleTablePK != null ? roleTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTable)) {
            return false;
        }
        RoleTable other = (RoleTable) object;
        if ((this.roleTablePK == null && other.roleTablePK != null) || (this.roleTablePK != null && !this.roleTablePK.equals(other.roleTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.RoleTable[ roleTablePK=" + roleTablePK + " ]";
    }
    
}
