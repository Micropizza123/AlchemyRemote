
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class MagentaDiamondHoeItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:magenta_diamond_hoe")
	public static final Item block = null;
	public MagentaDiamondHoeItem(AlchemyModElements instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1561;
			}

			public float getEfficiency() {
				return 8.5f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MagentaDiamondItem.block));
			}
		}, 0, 0f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("magenta_diamond_hoe"));
	}
}
