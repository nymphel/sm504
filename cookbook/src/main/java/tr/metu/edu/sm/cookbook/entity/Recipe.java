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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author rylai
 */
@Entity
@Table(name = "recipe")
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")})
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "difficulty")
    private String difficulty;
    @Basic(optional = false)
    @Column(name = "servingQty")
    private int servingQty;
    @Basic(optional = false)
    @Column(name = "prepTime")
    private int prepTime;
    @Basic(optional = false)
    @Column(name = "cookingTime")
    private int cookingTime;
    @Basic(optional = false)
    @Column(name = "directive")
    private String directive;
    @Column(name = "tip")
    private String tip;
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "createdDate")
    private String createdDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "cookingMethod", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cookingmethod cookingMethod;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "cuisine", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuisine cuisine;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<Recipeingredient> recipeingredientList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<Rating> ratingList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe")
    private List<Comment> commentList;

    public Recipe() {
    }

    public Recipe(Integer id) {
        this.id = id;
    }

    public Recipe(Integer id, String name, String difficulty, int servingQty, int prepTime, int cookingTime, String directive, String createdDate, String status) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.servingQty = servingQty;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.directive = directive;
        this.createdDate = createdDate;
        this.status = status;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getServingQty() {
        return servingQty;
    }

    public void setServingQty(int servingQty) {
        this.servingQty = servingQty;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Cookingmethod getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(Cookingmethod cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public List<Recipeingredient> getRecipeingredientList() {
        return recipeingredientList;
    }

    public void setRecipeingredientList(List<Recipeingredient> recipeingredientList) {
        this.recipeingredientList = recipeingredientList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
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
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.metu.edu.sm.cookbook.entity.Recipe[ id=" + id + " ]";
    }
    
    @Transient
    public double getAverageRating() {
    	double r = 0;
    	
    	if(this.ratingList != null && !this.ratingList.isEmpty()) {
    		for (Rating rating : this.ratingList) {
    			r += (double)(rating.getRating());
			}
    		r = r / (double)(this.ratingList.size());
    	}
    	
    	return r;
    }
    
}
