
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
public class AdvancedIceDaggerItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:advanced_ice_dagger")
	public static final Item block = null;
	public AdvancedIceDaggerItem(AlchemyModElements instance) {
		super(instance, 178);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3042;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 5.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 44;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PrismarineGemItem.block), new ItemStack(GemOfIceItem.block));
			}
		}, 3, -1.5f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("advanced_ice_dagger"));
	}
}
