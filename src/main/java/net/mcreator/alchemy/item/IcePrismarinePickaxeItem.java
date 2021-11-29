
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

import java.util.List;

@AlchemyModElements.ModElement.Tag
public class IcePrismarinePickaxeItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:ice_prismarine_pickaxe")
	public static final Item block = null;
	public IcePrismarinePickaxeItem(AlchemyModElements instance) {
		super(instance, 180);
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
				return 4;
			}

			public int getEnchantability() {
				return 44;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PrismarineGemItem.block), new ItemStack(GemOfIceItem.block));
			}
		}, 1, -2.7999999999999998f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A75Epic Tool"));
			}
		}.setRegistryName("ice_prismarine_pickaxe"));
	}
}
