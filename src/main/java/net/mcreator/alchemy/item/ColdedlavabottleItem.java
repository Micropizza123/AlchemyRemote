
package net.mcreator.alchemy.item;

@AlchemyModElements.ModElement.Tag
public class ColdedlavabottleItem extends AlchemyModElements.ModElement {

	@ObjectHolder("alchemy:coldedlavabottle")
	public static final Item block = null;

	public ColdedlavabottleItem(AlchemyModElements instance) {
		super(instance, 40);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("coldedlavabottle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
