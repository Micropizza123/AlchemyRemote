package net.mcreator.alchemy.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.AlchemyModVariables;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;

public class EnderStaffRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure EnderStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyMod.LOGGER.warn("Failed to load dependency x for procedure EnderStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyMod.LOGGER.warn("Failed to load dependency y for procedure EnderStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyMod.LOGGER.warn("Failed to load dependency z for procedure EnderStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure EnderStaffRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		AlchemyModVariables.MapVariables.get(world).Speed = (double) 0.1;
		AlchemyModVariables.MapVariables.get(world).syncData(world);
		AlchemyModVariables.MapVariables.get(world).Yaw = (double) (entity.rotationYaw);
		AlchemyModVariables.MapVariables.get(world).syncData(world);
		if ((AlchemyModVariables.MapVariables.get(world).EnderStaffAbility == (false))) {
			AlchemyModVariables.MapVariables.get(world).EnderStaffAbility = (boolean) (true);
			AlchemyModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new DragonFireballEntity(EntityType.DRAGON_FIREBALL, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				entityToSpawn.setMotion(
						(AlchemyModVariables.MapVariables.get(world).Speed
								* Math.cos(((AlchemyModVariables.WorldVariables.get(world).WarpingPearl + 90) * (Math.PI / 180)))),
						((entity.getMotion().getY()) + 0.2), (AlchemyModVariables.MapVariables.get(world).Speed
								* Math.sin(((AlchemyModVariables.WorldVariables.get(world).WarpingPearl + 90) * (Math.PI / 180)))));
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					AlchemyModVariables.MapVariables.get(world).EnderStaffAbility = (boolean) (false);
					AlchemyModVariables.MapVariables.get(world).syncData(world);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 100);
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Ability on cooldown"), (true));
			}
		}
	}
}
