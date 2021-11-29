
package net.mcreator.alchemy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.AlchemyModElements;

import java.util.List;

@AlchemyModElements.ModElement.Tag
public class TotemOfStrengthItem extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:totem_of_strength")
	public static final Item block = null;
	public TotemOfStrengthItem(AlchemyModElements instance) {
		super(instance, 156);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON));
			setRegistryName("totem_of_strength");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("If your health gets lower that 3 you get strength 10"));
			list.add(new StringTextComponent("\u00A76Mythical item"));
		}
	}
}
