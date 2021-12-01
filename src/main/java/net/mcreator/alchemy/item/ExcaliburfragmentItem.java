
package net.mcreator.alchemy.item;

@AlchemyModElements.ModElement.Tag
public class ExcaliburfragmentItem extends AlchemyModElements.ModElement {

	@ObjectHolder("alchemy:excaliburfragment")
	public static final Item block = null;

	public ExcaliburfragmentItem(AlchemyModElements instance) {
		super(instance, 513);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("excaliburfragment");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Excalibur"));
			list.add(new StringTextComponent("\u00A76Mythical item"));
		}

	}

}
