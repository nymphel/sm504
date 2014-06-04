/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.metu.edu.sm.cookbook.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rylai
 */
@Entity
@Table(name = "ingredient")
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")})
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "calorie")
    private double calorie;
    @Column(name = "allergenic")
    private String allergenic;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ingredient")
    private List<Recipeingredient> recipeingredientList;
    @JoinColumn(name = "calorieUnit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit calorieUnit;

    public Ingredient() {
    }

    public Ingredient(Integer id) {
        this.id = id;
    }

    public Ingredient(Integer id, String name, double calorie) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public String getAllergenic() {
        return allergenic;
    }

    public void setAllergenic(String allergenic) {
        this.allergenic = allergenic;
    }

    public List<Recipeingredient> getRecipeingredientList() {
        return recipeingredientList;
    }

    public void setRecipeingredientList(List<Recipeingredient> recipeingredientList) {
        this.recipeingredientList = recipeingredientList;
    }

    public Unit getCalorieUnit() {
        return calorieUnit;
    }

    public void setCalorieUnit(Unit calorieUnit) {
        this.calorieUnit = calorieUnit;
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
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Ingredient[ id=" + id + " ]";
    }
    
}
