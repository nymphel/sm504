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
@Table(name = "unit")
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")})
public class Unit extends IdName implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "unit")
    private List<Recipeingredient> recipeingredientList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "calorieUnit")
    private List<Ingredient> ingredientList;

    public List<Recipeingredient> getRecipeingredientList() {
        return recipeingredientList;
    }

    public void setRecipeingredientList(List<Recipeingredient> recipeingredientList) {
        this.recipeingredientList = recipeingredientList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Unit[ id=" + id + " ]";
    }
    
}
