package tr.metu.edu.sm.cookbook.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.entity.Comment;
import tr.metu.edu.sm.cookbook.entity.Cookingmethod;
import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.entity.Ingredient;
import tr.metu.edu.sm.cookbook.entity.Ingredientform;
import tr.metu.edu.sm.cookbook.entity.Rating;
import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.Recipeingredient;
import tr.metu.edu.sm.cookbook.entity.Unit;
import tr.metu.edu.sm.cookbook.entity.User;
import tr.metu.edu.sm.cookbook.service.CategoryService;
import tr.metu.edu.sm.cookbook.service.CommentService;
import tr.metu.edu.sm.cookbook.service.CookingmethodService;
import tr.metu.edu.sm.cookbook.service.CuisineService;
import tr.metu.edu.sm.cookbook.service.IngredientService;
import tr.metu.edu.sm.cookbook.service.IngredientformService;
import tr.metu.edu.sm.cookbook.service.RatingService;
import tr.metu.edu.sm.cookbook.service.RecipeService;
import tr.metu.edu.sm.cookbook.service.RecipeingredientService;
import tr.metu.edu.sm.cookbook.service.UnitService;
import tr.metu.edu.sm.cookbook.util.FacesUtil;

@Component
@Qualifier("recipeBean")
@Scope("session")
public class RecipeBean {
	
	@Autowired
	private RecipeService<Recipe, Integer> service;
	
	@Autowired
	private RatingService<Rating, Integer> serviceRating;
	
	@Autowired
	private CommentService<Comment, Integer> serviceComment;
	
	@Autowired
	private IngredientService<Ingredient, Integer> serviceIngredient;
	
	@Autowired
	private IngredientformService<Ingredientform, Integer> serviceIngredientform;
	
	@Autowired
	private RecipeingredientService<Recipeingredient, Integer> serviceRecipeingredient;
	
	@Autowired 
	private CategoryService<Category, Integer> serviceCategory;
	
	@Autowired 
	private CuisineService<Cuisine, Integer> serviceCuisine;
	
	@Autowired 
	private CookingmethodService<Cookingmethod, Integer> serviceCookingmethod;
	
	@Autowired 
	private UnitService<Unit, Integer> serviceUnit;

	private Recipe recipe = null;
	private Recipeingredient recipeingredient = null;
	private List<Recipeingredient> ingredients = new ArrayList<>();
	
	private List<Recipe> reciperequests = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		recipe = new Recipe();
		recipe.setCategory(new Category());
		recipe.setCookingMethod(new Cookingmethod());
		recipe.setCuisine(new Cuisine());
		
		HttpSession session = FacesUtil.getSession();
		User user = (User) session.getAttribute("user");
		recipe.setUserId(user);
		
		recipe.setCreatedDate("2014");
		recipe.setStatus("requested");
		
		recipeingredient = new Recipeingredient();
		recipeingredient.setIngredient(new Ingredient());
		recipeingredient.setIngredientForm(new Ingredientform());
		recipeingredient.setUnit(new Unit());
	}

	public void approve() {

	}

	public void reject() {

	}

	public void create() {
		service.create(recipe);
		recipe = new Recipe();
	}

	public void update() {

	}

	public void delete() {

	}

	public Recipe getById(Integer id) {
		return null;
	}

	public List<Recipe> getAll() {
		return service.getAll();
	}

	public void rate(int rating) {

	}

	public void comment(String comment) {

	}

	public void share(int rating) {

	}
	
	public String show()
	{
		return "";
	}
	
	public String showrequest()
	{
		return "";
	}
	
	public List<Recipe> search(Recipe recipe) {
		return null;
	}
	
	public List<Recipe> advancedSearch(Recipe recipe) {
		return null;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public Recipeingredient getRecipeingredient() {
		return recipeingredient;
	}

	public void setRecipeingredient(Recipeingredient recipeingredient) {
		this.recipeingredient = recipeingredient;
	}

	public List<Recipeingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Recipeingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Recipe> getReciperequests() {
		return getAll();
	}

	public void setReciperequests(List<Recipe> reciperequests) {
		this.reciperequests = reciperequests;
	}

	public List<Ingredient> complete(String query) {
		return serviceIngredient.searchIngredients(query);
    }

}
