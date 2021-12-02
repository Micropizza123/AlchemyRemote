
package net.mcreator.alchemy.item;

@AlchemyModElements.ModElement.Tag
public class EnchantingScrollItem extends AlchemyModElements.ModElement {

	@ObjectHolder("alchemy:enchanting_scroll")
	public static final Item block = null;

	public EnchantingScrollItem(AlchemyModElements instance) {
		super(instance, 525);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("enchanting_scroll");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A77Mending"));
			list.add(new StringTextComponent("\u00A7d+2\u00A75Attack Damage"));
		}

	}

}
