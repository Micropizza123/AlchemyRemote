package net.mcreator.alchemy.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.item.PotionOfDamageItem;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;

public class StrenghtinInventoryProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure StrenghtinInventory!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(PotionOfDamageItem.block)) : false)) {
			return (true);
		}
		return (false);
	}
}
