/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.metu.edu.sm.cookbook.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tr.metu.edu.sm.cookbook.entity.parent.IdName;

/**
 *
 * @author rylai
 */
@Entity
@Table(name = "cuisine")
@NamedQueries({
    @NamedQuery(name = "Cuisine.findAll", query = "SELECT c FROM Cuisine c")})
public class Cuisine extends IdName implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuisine")
    private List<Recipe> recipeList;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuisine)) {
            return false;
        }
        Cuisine other = (Cuisine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Cuisine[ id=" + id + " ]";
    }
    
}
