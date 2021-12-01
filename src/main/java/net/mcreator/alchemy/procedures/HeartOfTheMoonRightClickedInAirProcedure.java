package net.mcreator.alchemy.procedures;

public class HeartOfTheMoonRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure HeartOfTheMoonRightClickedInAir!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");

		if ((!((world instanceof World) ? ((World) world).isDaytime() : false))) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).setDayTime((int) 0);
		}
	}

}
