package com.hudshow.neoforge.data.recipe.provider;

import com.hudshow.neoforge.core.init.ItemInit;
import com.hudshow.neoforge.data.recipe.MainModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public FurnaceRecipeProvider(DataGenerator generator, RecipeOutput output) {
        super(generator);
        this.output = output;
    }

    public void build() {
//        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.RAW_EXAMPLE.get()), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.6f, 300)
//                .unlockedBy("has_item", has(ItemInit.RAW_EXAMPLE.get()))
//                .save(output, getModId("raw_example_smelting"));
//
//        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemInit.RAW_EXAMPLE.get()), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.3f, 300)
//                .unlockedBy("has_item", has(ItemInit.RAW_EXAMPLE.get()))
//                .save(output, getModId("raw_example_blasting"));
    }
}
