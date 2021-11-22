package net.mcreator.alchemy.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.AlchemyMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class EnderenergymeterRightClickedOnBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				AlchemyMod.LOGGER.warn("Failed to load dependency direction for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyMod.LOGGER.warn("Failed to load dependency x for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyMod.LOGGER.warn("Failed to load dependency y for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyMod.LOGGER.warn("Failed to load dependency z for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure EnderenergymeterRightClickedOnBlock!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((((new Object() {
				public int getEnergyStored(IWorld world, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos((int) x, (int) y, (int) z)))) + "" + ("/") + "" + ((new Object() {
				public int getMaxEnergyStored(IWorld world, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
					return _retval.get();
				}
			}.getMaxEnergyStored(world, new BlockPos((int) x, (int) y, (int) z)))) + "" + (" energy at ") + "" + (direction))), (true));
		}
	}
}
