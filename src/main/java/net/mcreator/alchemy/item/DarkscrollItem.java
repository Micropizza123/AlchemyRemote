
package net.mcreator.alchemy.item;

@AlchemyModElements.ModElement.Tag
public class DarkscrollItem extends AlchemyModElements.ModElement {

	@ObjectHolder("alchemy:darkscroll")
	public static final Item block = null;

	public DarkscrollItem(AlchemyModElements instance) {
		super(instance, 517);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("darkscroll");
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
			list.add(new StringTextComponent("\u00A7aUncommon item"));
		}

	}

}
