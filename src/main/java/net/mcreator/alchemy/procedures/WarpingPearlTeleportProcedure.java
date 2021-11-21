package net.mcreator.alchemy.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.item.WarpingpearlItem;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;
import java.util.Collections;

public class WarpingPearlTeleportProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure WarpingPearlTeleport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(WarpingpearlItem.block))
				: false) == (true))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((entity.getPersistentData().getDouble("WX")), (entity.getPersistentData().getDouble("WY")),
						(entity.getPersistentData().getDouble("WZ")));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPersistentData().getDouble("WX")),
							(entity.getPersistentData().getDouble("WY")), (entity.getPersistentData().getDouble("WZ")), _ent.rotationYaw,
							_ent.rotationPitch, Collections.emptySet());
				}
			}
		}
	}
}
