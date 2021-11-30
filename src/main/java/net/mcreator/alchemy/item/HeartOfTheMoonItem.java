
package net.mcreator.alchemy.item;

@AlchemyModElements.ModElement.Tag
public class HeartOfTheMoonItem extends AlchemyModElements.ModElement {

	@ObjectHolder("alchemy:heart_of_the_moon")
	public static final Item block = null;

	public HeartOfTheMoonItem(AlchemyModElements instance) {
		super(instance, 515);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AlchemyItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("heart_of_the_moon");
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
			list.add(new StringTextComponent("Right click:"));
			list.add(new StringTextComponent("Set to day (Must be Night)"));
			list.add(new StringTextComponent("\u00A76Mythical item"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("world", world);

				HeartOfTheMoonRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("world", world);

				HeartOfTheMoonRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
