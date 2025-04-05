package com.hudshow.neoforge.data.recipe;

import com.hudshow.neoforge.MagicMirror;
import com.hudshow.neoforge.data.recipe.provider.FurnaceRecipeProvider;
import com.hudshow.neoforge.data.recipe.provider.NormalCraftingTableRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;

    public MainModRecipeProvider(DataGenerator generator) {
        super(generator.getPackOutput());
        this.generator = generator;
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, recipeOutput).build();
        //new FurnaceRecipeProvider(generator, recipeOutput).build();
    }

    public ResourceLocation getModId(String path) {
        return new ResourceLocation(MagicMirror.MOD_ID, path);
    }
}
