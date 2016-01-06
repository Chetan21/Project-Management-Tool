/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Chetan
 */
@Embeddable
public class RoleTablePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "role_id")
    private int roleId;
    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;

    public RoleTablePK() {
    }

    public RoleTablePK(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (roleName != null ? roleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTablePK)) {
            return false;
        }
        RoleTablePK other = (RoleTablePK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.RoleTablePK[ roleId=" + roleId + ", roleName=" + roleName + " ]";
    }
    
}
