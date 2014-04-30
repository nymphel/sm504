/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.metu.edu.sm.cookbook.entity;

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
 * @author rylai
 */
@Entity
@Table(name = "recipeingredient")
@NamedQueries({
    @NamedQuery(name = "Recipeingredient.findAll", query = "SELECT r FROM Recipeingredient r")})
public class Recipeingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number")
    private double number;
    @JoinColumn(name = "ingredientForm", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingredientform ingredientForm;
    @JoinColumn(name = "unit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unit;
    @JoinColumn(name = "ingredient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingredient ingredient;
    @JoinColumn(name = "recipe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recipe recipe;

    public Recipeingredient() {
    }

    public Recipeingredient(Integer id) {
        this.id = id;
    }

    public Recipeingredient(Integer id, double number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public Ingredientform getIngredientForm() {
        return ingredientForm;
    }

    public void setIngredientForm(Ingredientform ingredientForm) {
        this.ingredientForm = ingredientForm;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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
        if (!(object instanceof Recipeingredient)) {
            return false;
        }
        Recipeingredient other = (Recipeingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Recipeingredient[ id=" + id + " ]";
    }
    
}
