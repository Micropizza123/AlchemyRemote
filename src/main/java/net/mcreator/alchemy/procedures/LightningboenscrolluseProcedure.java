package net.mcreator.alchemy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.AlchemyModVariables;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;

public class LightningboenscrolluseProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure Lightningboenscrolluse!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure Lightningboenscrolluse!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((AlchemyModVariables.MapVariables.get(world).Lightningborns_abilities == 0)) {
			AlchemyModVariables.MapVariables.get(world).Lightningborns_abilities = (double) 1;
			AlchemyModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightningborn's abilities on"), (true));
			}
		} else if ((AlchemyModVariables.MapVariables.get(world).Lightningborns_abilities == 1)) {
			AlchemyModVariables.MapVariables.get(world).Lightningborns_abilities = (double) 0;
			AlchemyModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightningborn's abilities off"), (true));
			}
		}
	}
}
