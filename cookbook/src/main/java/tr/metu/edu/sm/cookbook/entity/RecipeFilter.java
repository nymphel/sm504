package tr.metu.edu.sm.cookbook.entity;

import java.io.Serializable;
import java.util.List;

public class RecipeFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<String> ingredients;
	private List<String> excludedingredients;
	private int categoryid;
	private int cuisinetypeid;
	private int cookingmethodid;
	private int maxcookingtime;
	private int maxcalories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getExcludedingredients() {
		return excludedingredients;
	}

	public void setExcludedingredients(List<String> excludedingredients) {
		this.excludedingredients = excludedingredients;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getCuisinetypeid() {
		return cuisinetypeid;
	}

	public void setCuisinetypeid(int cuisinetypeid) {
		this.cuisinetypeid = cuisinetypeid;
	}

	public int getCookingmethodid() {
		return cookingmethodid;
	}

	public void setCookingmethodid(int cookingmethodid) {
		this.cookingmethodid = cookingmethodid;
	}

	public int getMaxcookingtime() {
		return maxcookingtime;
	}

	public void setMaxcookingtime(int maxcookingtime) {
		this.maxcookingtime = maxcookingtime;
	}

	public int getMaxcalories() {
		return maxcalories;
	}

	public void setMaxcalories(int maxcalories) {
		this.maxcalories = maxcalories;
	}

}
