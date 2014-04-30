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
@Table(name = "ingredientform")
@NamedQueries({
    @NamedQuery(name = "Ingredientform.findAll", query = "SELECT i FROM Ingredientform i")})
public class Ingredientform extends IdName implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredientForm")
    private List<Recipeingredient> recipeingredientList;

    public List<Recipeingredient> getRecipeingredientList() {
        return recipeingredientList;
    }

    public void setRecipeingredientList(List<Recipeingredient> recipeingredientList) {
        this.recipeingredientList = recipeingredientList;
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
        if (!(object instanceof Ingredientform)) {
            return false;
        }
        Ingredientform other = (Ingredientform) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Ingredientform[ id=" + id + " ]";
    }
    
}
