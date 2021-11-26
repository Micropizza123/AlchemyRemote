
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class IcePrismarinePickaxeItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:ice_prismarine_pickaxe")
	public static final Item block = null;
	public IcePrismarinePickaxeItem(AlchemyModElements instance) {
		super(instance, 179);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3042;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
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
		}, 1, -2.7999999999999998f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("ice_prismarine_pickaxe"));
	}
}
