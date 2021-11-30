
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

import java.util.List;

@AlchemyModElements.ModElement.Tag
public class EnderSwordItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:ender_sword")
	public static final Item block = null;
	public EnderSwordItem(AlchemyModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1754;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 5.6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnderShardItem.block));
			}
		}, 3, -2.4f, new Item.Properties().group(AlchemyItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A75Epic Weapon"));
			}
		}.setRegistryName("ender_sword"));
	}
}
