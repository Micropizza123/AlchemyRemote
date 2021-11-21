
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.FishingRodItem;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class GoldenFishingRodItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:golden_fishing_rod")
	public static final Item block = null;
	public GoldenFishingRodItem(AlchemyModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setRegistryName("golden_fishing_rod"));
	}
	private static class ItemToolCustom extends FishingRodItem {
		protected ItemToolCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxDamage(2000).isImmuneToFire());
		}

		@Override
		public int getItemEnchantability() {
			return 40;
		}

		@Override
		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
			Item repairItem = repair.getItem();
			return repairItem == Items.GOLD_INGOT;
		}
	}
}
