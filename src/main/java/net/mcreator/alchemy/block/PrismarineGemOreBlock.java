
package net.mcreator.alchemy.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.alchemy.itemgroup.AlchemyItemGroup;
import net.mcreator.alchemy.item.PrismarineGemItem;
import net.mcreator.alchemy.AlchemyModElements;

import java.util.List;
import java.util.Collections;

@AlchemyModElements.ModElement.Tag
public class PrismarineGemOreBlock extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:prismarine_gem_ore")
	public static final Block block = null;
	public PrismarineGemOreBlock(AlchemyModElements instance) {
		super(instance, 170);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(AlchemyItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.ANCIENT_DEBRIS).hardnessAndResistance(35f, 1200f).setLightLevel(s -> 0)
					.harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("prismarine_gem_ore");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(PrismarineGemItem.block));
		}
	}
}
