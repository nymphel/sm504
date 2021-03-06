package tr.metu.edu.sm.cookbook.mbean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
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
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

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
	private int rating;

	public String getLoadCreate() {
		refreshRecipe();
		refreshRecipeIngredient();
		
		return "recipe";
	}

	private void refreshRecipe() {
		recipe = new Recipe();
		recipe.setCategory(new Category());
		recipe.setCookingMethod(new Cookingmethod());
		recipe.setCuisine(new Cuisine());
		recipe.setCookingTime(30);
		recipe.setPrepTime(15);
		recipe.setServingQty(4);

		HttpSession session = FacesUtil.getSession();
		User user = (User) session.getAttribute("user");
		recipe.setUserId(user);

		recipe.setCreatedDate("2014");
		recipe.setStatus("requested");

		recipe.setRecipeingredientList(ingredients);
	}

	private void refreshRecipeIngredient() {
		recipeingredient = new Recipeingredient();
		recipeingredient.setNumber(1);
		recipeingredient.setIngredient(new Ingredient());
		recipeingredient.setIngredientForm(new Ingredientform());
		recipeingredient.setUnit(new Unit());
		recipeingredient.setRecipe(recipe);
	}

	public void approve() {

	}

	public void reject() {

	}

	public void create() {
		service.create(recipe);
		
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createRecipeSuccessful"));

		ingredients = new ArrayList<>();
		refreshRecipeIngredient();
		refreshRecipe();
	}

	public void update() {

	}

	public void delete() {

	}

	public Recipe getById(Integer id) {
		return null;
	}
	
	public String showRecipe(Integer id) {
		recipe = service.getById(id);
		
		return "showrecipe";
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

	public List<Ingredient> complete(String query) {
		return serviceIngredient.searchIngredients(query);
	}

	public void addIngredient() {
		
		if(recipeingredient.getIngredient().getId() == 0) {
			MessagesUtil.setGlobalWarningMessage(MessagesUtil
					.getValue("ingredientRequired"));
			return;
		}
		
		Ingredient ingredient = serviceIngredient.getById(recipeingredient
				.getIngredient().getId());
		recipeingredient.setIngredient(ingredient);

		Unit unit = serviceUnit.getById(recipeingredient.getUnit().getId());
		recipeingredient.setUnit(unit);

		Ingredientform ingredientform = serviceIngredientform
				.getById(recipeingredient.getIngredientForm().getId());
		recipeingredient.setIngredientForm(ingredientform);

		UUID uuid = UUID.randomUUID();
		recipeingredient.setUuid(uuid.toString());

		ingredients.add(recipeingredient);

		refreshRecipeIngredient();
	}

	public void removeIngredient(String uuid) {
		if (ingredients != null && !ingredients.isEmpty()) {
			List<Recipeingredient> refined = new ArrayList<>();

			for (Recipeingredient ingredient : ingredients) {
				if (!uuid.equals(ingredient.getUuid())) {
					refined.add(ingredient);
				}
			}

			this.ingredients = refined;
		}
	}
	
	public int getTotalCalorie() {
		int total = 0;
		for (Recipeingredient recipeingredient : ingredients) {
			
			Ingredient ingredient = recipeingredient.getIngredient();
			if(ingredient != null && ingredient.getCalorieUnit().getId() == recipeingredient.getUnit().getId()) {
				int number = recipeingredient.getNumber();
				double calorie = ingredient.getCalorie();
				calorie = calorie * number;
				total += calorie;
			}
		}
		
		return total;
	}

	public int getRating() {
		HttpSession session = FacesUtil.getSession();
		User user = (User) session.getAttribute("user");
		
		Rating userRating = getUserRating(user);
		if(userRating != null) {
			this.rating = userRating.getRating();
		}
		
		return this.rating;
	}
	
	public Rating getUserRating(User user) {
		this.recipe = service.getById(this.recipe.getId());
		List<Rating> ratingList = this.recipe.getRatingList();
		if(ratingList != null && !ratingList.isEmpty()) {
			
			for (Rating rating : ratingList) {
				User rater = rating.getUserId();
				if(rater.getId() == user.getId()) {
					return rating;
				}
			}
		}
		
		return null;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void onrate(RateEvent rateEvent) {
		
		HttpSession session = FacesUtil.getSession();
		User user = (User) session.getAttribute("user");
		
		Rating userRating = getUserRating(user);
		
		int score = ((Integer) rateEvent.getRating()).intValue();
		Rating rate = new Rating();
		rate.setRating(score);
		rate.setRecipe(recipe);
		rate.setUserId(user);
		
		if(userRating == null) {
			serviceRating.create(rate);
		} else {
			rate.setId(userRating.getId());
			serviceRating.update(rate);
		}
		
	}
   
    public void upload(FileUploadEvent event) {
    	UploadedFile file = event.getFile();
        if(file != null) {
        	recipe.setPhoto(file.getContents());
        }
    }
    
    public StreamedContent getPhoto() {
    	byte[] photo = recipe.getPhoto();
    	if(photo != null && photo.length > 0) {
    		return new DefaultStreamedContent(new ByteArrayInputStream(photo));
    	}
    	
    	return null;
    }
    

    
    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            Integer recipeId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("recipeId"));
            Recipe recipe = service.getById(recipeId);
            
            byte[] photo = recipe.getPhoto();
            if(photo == null) {
            	return null;
            }
            
            return new DefaultStreamedContent(new ByteArrayInputStream(photo));
        }
    }

}
