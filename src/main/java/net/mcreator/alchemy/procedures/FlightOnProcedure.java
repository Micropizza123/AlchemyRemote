package net.mcreator.alchemy.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.potion.FlightPotionEffect;
import net.mcreator.alchemy.item.MalysiumArmorItem;
import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;
import java.util.Collection;

public class FlightOnProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure FlightOn!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MalysiumArmorItem.body)) : false)
				|| (new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == FlightPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)))) {
			return (true);
		}
		return (false);
	}
}
