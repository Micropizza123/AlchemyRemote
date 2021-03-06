
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class CrystalBerryItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:crystal_berry")
	public static final Item block = null;
	public CrystalBerryItem(AlchemyModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.3f).build()));
			setRegistryName("crystal_berry");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 15;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
