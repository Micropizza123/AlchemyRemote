
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.FishingRodItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

import java.util.List;

@AlchemyModElements.ModElement.Tag
public class AmethystFishingRodItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:amethyst_fishing_rod")
	public static final Item block = null;
	public AmethystFishingRodItem(AlchemyModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Easily Enchantable"));
			}
		}.setRegistryName("amethyst_fishing_rod"));
	}
	private static class ItemToolCustom extends FishingRodItem {
		protected ItemToolCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxDamage(1000).isImmuneToFire());
		}

		@Override
		public int getItemEnchantability() {
			return 40;
		}

		@Override
		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
			Item repairItem = repair.getItem();
			return repairItem == MagentaDiamondItem.block || repairItem == MagentaCrystalShardItem.block;
		}
	}
}
