
package net.mcreator.alchemy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.Potions;
import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.mcreator.alchemy.item.RelicOfLifeItem;
import net.mcreator.alchemy.item.PotionOfLifeItem;

@AlchemyModElements.ModElement.Tag
public class PotionOfLifeRecipeBrewingRecipe extends AlchemyModElements.ModElement {
	public PotionOfLifeRecipeBrewingRecipe(AlchemyModElements instance) {
		super(instance, 190);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			Item inputItem = input.getItem();
			return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION)
					&& PotionUtils.getPotionFromItem(input) == Potions.WATER;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == RelicOfLifeItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(PotionOfLifeItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
