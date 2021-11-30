
package net.mcreator.alchemy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alchemy.item.RecipeBookItem;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class AlchemyItemGroup extends AlchemyModElements.ModElement {
	public AlchemyItemGroup(AlchemyModElements instance) {
		super(instance, 227);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabalchemy") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RecipeBookItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
