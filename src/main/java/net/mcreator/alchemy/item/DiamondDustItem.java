
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class DiamondDustItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:diamond_dust")
	public static final Item block = null;
	public DiamondDustItem(AlchemyModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("diamond_dust");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
