package net.mcreator.alchemy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemy.AlchemyMod;

import java.util.Map;
import java.util.HashMap;

public class MagicStaffRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyMod.LOGGER.warn("Failed to load dependency entity for procedure MagicStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyMod.LOGGER.warn("Failed to load dependency itemstack for procedure MagicStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyMod.LOGGER.warn("Failed to load dependency x for procedure MagicStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyMod.LOGGER.warn("Failed to load dependency y for procedure MagicStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyMod.LOGGER.warn("Failed to load dependency z for procedure MagicStaffRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyMod.LOGGER.warn("Failed to load dependency world for procedure MagicStaffRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
		if ((entity.isSneaking())) {
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) < 7)) {
				(itemstack).getOrCreateTag().putDouble("PowerChoice", (((itemstack).getOrCreateTag().getDouble("PowerChoice")) + 1));
				if (((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 1) || (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 2))
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 3))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 4)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 5))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 6)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 7))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 8)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 9))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if (((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 10)
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 7))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 7)) {
					(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 2)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to ONE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to TWO"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to THREE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to FOUR"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to FIVE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 1)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to BONUS SLOT"))), (true));
					}
				}
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("XPAmount")) <= 0)) {
			if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 10)) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", 0);
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("XPAmount")) <= 0)) {
			if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 1)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 2);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 150);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 2!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 2)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 3);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot1", "No Upgrade");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 3!"), (true));
				}
				(itemstack).getOrCreateTag().putDouble("XPAmount", 200);
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 3)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 4);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 250);
				(itemstack).getOrCreateTag().putString("StaffSlot2Power", "Empty Slot");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 4!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 4)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 5);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 300);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 5!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 5)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 6);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 350);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot2", "No Upgrade");
				(itemstack).getOrCreateTag().putString("StaffSlot3Power", "Empty Slot");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 6!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 6)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 7);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 400);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 7!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 7)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 8);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 450);
				(itemstack).getOrCreateTag().putString("StaffSlot4Power", "Empty Slot");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 8!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 8)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 9);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 500);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot3", "No Upgrade");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 9!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 9)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 10);
				(itemstack).getOrCreateTag().putString("StaffSlot5Power", "Empty Slot");
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 10!"), (true));
				}
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 0)) {
			(itemstack).getOrCreateTag().putDouble("ItemLevel", 1);
			(itemstack).getOrCreateTag().putDouble("XPAmount", 100);
			(itemstack).getOrCreateTag().putString("StaffSlot1Power", "Empty Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot2Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot3Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot4Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot5Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot1", "\u00A7cLocked Upgrade Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot2", "\u00A7cLocked Upgrade Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot3", "\u00A7cLocked Upgrade Slot");
		}
		if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 0)) {
			(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
		}
		if ((!(entity.isSneaking()))) {
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 1)) {
				if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus \u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus \u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus \u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus \u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus \u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
				if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus \u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus \u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus \u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus \u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus \u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
				if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus \u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus \u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus \u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus \u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus \u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 2)) {
				if (((((itemstack).getOrCreateTag().getString("StaffSlot1Power"))).equals("\u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot1Power"))).equals("\u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot1Power"))).equals("\u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot1Power"))).equals("\u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot1Power"))).equals("\u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3)) {
				if (((((itemstack).getOrCreateTag().getString("StaffSlot2Power"))).equals("\u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot2Power"))).equals("\u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot2Power"))).equals("\u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot2Power"))).equals("\u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot2Power"))).equals("\u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4)) {
				if (((((itemstack).getOrCreateTag().getString("StaffSlot3Power"))).equals("\u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot3Power"))).equals("\u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot3Power"))).equals("\u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot3Power"))).equals("\u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot3Power"))).equals("\u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5)) {
				if (((((itemstack).getOrCreateTag().getString("StaffSlot4Power"))).equals("\u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot4Power"))).equals("\u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot4Power"))).equals("\u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot4Power"))).equals("\u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot4Power"))).equals("\u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6)) {
				if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Fire Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7bIce Stalagtite Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						IceStagalitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLightning Strike Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A79Water Throw Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Teleportation Power"))) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);
						TeleportationStaffItemRightClickedInAirProcedure.executeProcedure($_dependencies);
					}
				}
			}
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		}
	}
}
