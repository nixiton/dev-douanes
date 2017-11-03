package com.douane.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hasina on 10/11/17.
 */
/*@Entity
@Table(name="role", catalog = "douane")*/
public class Role {

    /*private int roleId;

    private String role;

    private Set<UserRole> userRole = new HashSet<UserRole>(0);



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    public Integer getRoleId() {
        return this.roleId;
    }



    public void setRoleId(Integer id) {
        this.roleId = id;
    }

    @Column(name="role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role", cascade=CascadeType.ALL)
    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> user) {
        this.userRole = user;
    }*/

}