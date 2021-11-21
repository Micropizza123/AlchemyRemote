package net.mcreator.alchemy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.alchemy.block.IcestagaliteBlock;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;

public class IceStagalitePowerRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyMod.LOGGER.warn("Failed to load dependency itemstack for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyMod.LOGGER.warn("Failed to load dependency x for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyMod.LOGGER.warn("Failed to load dependency y for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyMod.LOGGER.warn("Failed to load dependency z for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure IceStagalitePowerRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPersistentData().getDouble("PlayerMana")) > 6)) {
			entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 7));
			(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 1));
			if ((((itemstack).getOrCreateTag().getBoolean("XPBonus")) == (true))) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 2));
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) + 3));
			}
			if (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z - 2)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z - 2)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 3)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 3)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z - 2)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z - 2)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) z))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) z), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z + 2)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z + 2)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 3)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 3)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z + 2)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z + 2)), IcestagaliteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 5), (int) z))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 5), (int) z), IcestagaliteBlock.block.getDefaultState(), 3);
			}
		}
	}
}
