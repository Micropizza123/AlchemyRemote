package net.mcreator.alchemy.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.alchemy.AlchemyMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

public class EnderBatteryUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyMod.LOGGER.warn("Failed to load dependency x for procedure EnderBatteryUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyMod.LOGGER.warn("Failed to load dependency y for procedure EnderBatteryUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyMod.LOGGER.warn("Failed to load dependency z for procedure EnderBatteryUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure EnderBatteryUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double east = 0;
		double south = 0;
		double north = 0;
		double west = 0;
		double down = 0;
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) (y - 1), (int) z)))) {
			down = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 10000));
			down = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos((int) x, (int) (y - 1), (int) z), (int) down));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) down;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
				int _amount = (int) down;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x - 1), (int) y, (int) z)))) {
			west = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 10000));
			west = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos((int) (x - 1), (int) y, (int) z), (int) west));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) west;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
				int _amount = (int) west;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x + 1), (int) y, (int) z)))) {
			east = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 10000));
			east = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos((int) (x + 1), (int) y, (int) z), (int) east));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) east;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
				int _amount = (int) east;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) y, (int) (z + 1))))) {
			south = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 10000));
			south = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos((int) x, (int) y, (int) (z + 1)), (int) south));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) south;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
				int _amount = (int) south;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) y, (int) (z - 1))))) {
			north = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 10000));
			north = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos((int) x, (int) y, (int) (z - 1)), (int) north));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) north;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
				int _amount = (int) north;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
	}
}
