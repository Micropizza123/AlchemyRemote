package net.mcreator.alchemy.procedures;

public class FirebornscrolluseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure Firebornscrolluse!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure Firebornscrolluse!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((AlchemyModVariables.MapVariables.get(world).Fireborns_abilities == 0)) {
			AlchemyModVariables.MapVariables.get(world).Fireborns_abilities = (double) 1;
			AlchemyModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fireborn's abilities on"), (true));
			}
		}
		if ((AlchemyModVariables.MapVariables.get(world).Fireborns_abilities == 1)) {
			AlchemyModVariables.MapVariables.get(world).Fireborns_abilities = (double) 0;
			AlchemyModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fireborn's abilities off"), (true));
			}
		}
	}

}
