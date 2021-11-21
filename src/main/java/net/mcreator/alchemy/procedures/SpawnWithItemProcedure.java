package net.mcreator.alchemy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.item.RecipeBookItem;
import net.mcreator.alchemy.AlchemyModVariables;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;
import java.util.HashMap;

public class SpawnWithItemProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure SpawnWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!AlchemyModVariables.PlayerJoinedWorldBefore)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(RecipeBookItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			AlchemyModVariables.PlayerJoinedWorldBefore = (boolean) (true);
		}
	}
}
