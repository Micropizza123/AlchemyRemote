
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
public class SharurItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:sharur")
	public static final Item block = null;
	public SharurItem(AlchemyModElements instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4062;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 8.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.4f, new Item.Properties().group(AlchemyItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The enchanted mace of Ninurta"));
				list.add(new StringTextComponent("\u00A76Mythical Weapon"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("sharur"));
	}
}
