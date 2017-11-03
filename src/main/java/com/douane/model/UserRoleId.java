package com.douane.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by hasina on 10/11/17.
 */
public class UserRoleId implements java.io.Serializable {

    /*public User user;
    public Role role;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    public User getUser() {
        return user;
    }

    public void setUser(User stock) {
        this.user = stock;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleId that = (UserRoleId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }*/
}
