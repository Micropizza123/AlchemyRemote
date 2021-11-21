
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class RetenateShowelItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:retenate_showel")
	public static final Item block = null;
	public RetenateShowelItem(AlchemyModElements instance) {
		super(instance, 450);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 2032;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 2.25f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(AlchemyItemGroup.tab)) {
		}.setRegistryName("retenate_showel"));
	}
}
