
package net.mcreator.alchemy.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.alchemy.block.ColdLavaBlock;

@Mod.EventBusSubscriber
public class ColdLavaFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ColdLavaBlock.block.asItem())
			event.setBurnTime(1600);
	}
}
