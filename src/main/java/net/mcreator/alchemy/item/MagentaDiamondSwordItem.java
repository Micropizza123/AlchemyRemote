
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class MagentaDiamondSwordItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:magenta_diamond_sword")
	public static final Item block = null;
	public MagentaDiamondSwordItem(AlchemyModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1561;
			}

			public float getEfficiency() {
				return 8.5f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MagentaDiamondItem.block));
			}
		}, 3, -2.4f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("magenta_diamond_sword"));
	}
}
