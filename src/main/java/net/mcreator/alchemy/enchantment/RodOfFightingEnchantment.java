
package net.mcreator.alchemy.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.alchemy.item.GoldenFishingRodItem;
import net.mcreator.alchemy.AlchemyModElements;

@AlchemyModElements.ModElement.Tag
public class RodOfFightingEnchantment extends AlchemyModElements.ModElement {
	@ObjectHolder("alchemy:rod_of_fighting")
	public static final Enchantment enchantment = null;
	public RodOfFightingEnchantment(AlchemyModElements instance) {
		super(instance, 320);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("rod_of_fighting"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 5;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == GoldenFishingRodItem.block)
				return true;
			if (stack.getItem() == Items.FISHING_ROD)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
