package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public RecipeBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        recipeRepository.saveAll(getRecipes());

    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipeList = new ArrayList<>();

        UnitOfMeasure teaspon = unitOfMeasureRepository.findByDescription("Teaspoon").get();

        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();

        UnitOfMeasure piece = unitOfMeasureRepository.findByDescription("Piece").get();

        UnitOfMeasure pinch = unitOfMeasureRepository.findByDescription("Pinch").get();





        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("How to Make Perfect Guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setDirections("Mix all");
        guacamoleRecipe.setSource("simply recipes");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.getCategories().add(categoryRepository.findByDescription("American").get());
        Notes gnote = new Notes();
        gnote.setRecipeNotes("Guacamole note");
        guacamoleRecipe.setNotes(gnote);
        gnote.setRecipe(guacamoleRecipe);

        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), "ripe avocados", piece, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(new BigDecimal("0.25"), "salt", teaspon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "fresh lime juice or lemon juice", tablespoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), " minced red onion or thinly sliced green onion", tablespoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), " chiles, stems and seeds removed, minced", piece, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), "cilantro (leaves and tender stems), finely chopped", tablespoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "freshly grated black pepper", piece, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(new BigDecimal("0.5"), " ripe tomato, seeds and pulp removed, chopped", pinch, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "Red radishes or jicama, to garnish", piece, guacamoleRecipe));



        recipeList.add(guacamoleRecipe);

        Recipe spicyGrilledChickenTacosRecipe = new Recipe();
        spicyGrilledChickenTacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacosRecipe.setDifficulty(Difficulty.EASY);
        spicyGrilledChickenTacosRecipe.setPrepTime(20);
        spicyGrilledChickenTacosRecipe.setCookTime(15);
        spicyGrilledChickenTacosRecipe.setServings(6);
        spicyGrilledChickenTacosRecipe.setDirections("Grill the chiken! NOW!!");
        spicyGrilledChickenTacosRecipe.setSource("simply recipes");
        spicyGrilledChickenTacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        guacamoleRecipe.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        Notes cnote = new Notes();
        cnote.setRecipeNotes("Spicy Chicken note");
        spicyGrilledChickenTacosRecipe.setNotes(cnote);
        cnote.setRecipe(spicyGrilledChickenTacosRecipe);


        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), "fresh lime juice or lemon ancho chili powder", tablespoon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "dried oregano", teaspon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "dried cumin", teaspon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "sugar", teaspon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(new BigDecimal("1.5"), "salt", teaspon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "garlic, finely chopped", piece, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(1), "finely grated orange zest", tablespoon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(3), "fresh-squeezed orange juice", tablespoon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(2), "olive oil", tablespoon, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient(BigDecimal.valueOf(6), "skinless, boneless chicken thighs ", piece, spicyGrilledChickenTacosRecipe));

        recipeList.add(spicyGrilledChickenTacosRecipe);

        return recipeList;
    }



}
