// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelsnake extends EntityModel<Entity> {
	private final ModelRenderer chestplate;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer Rarm;
	private final ModelRenderer Larm;

	public Modelsnake() {
		texWidth = 64;
		texHeight = 64;

		chestplate = new ModelRenderer(this);
		chestplate.setPos(0.0F, 0.0F, 0.0F);
		chestplate.texOffs(0, 54).addBox(-4.0F, 2.0F, -3.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(0, 54).addBox(-4.0F, 2.0F, 2.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(8, 55).addBox(-4.0F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(7, 55).addBox(2.0F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(7, 55).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(8, 54).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(10, 60).addBox(-4.0F, 11.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(5, 49).addBox(3.0F, 11.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(0, 62).addBox(2.0F, 1.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(0, 62).addBox(-4.0F, 1.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(0, 62).addBox(-4.0F, 0.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(0, 62).addBox(3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(10, 56).addBox(-4.0F, 11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chestplate.texOffs(7, 60).addBox(3.0F, 11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.309F, 1.309F, 0.0F);
		cube_r1.texOffs(0, 0).addBox(6.6F, -3.5F, 11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(60, 62).addBox(7.0F, -4.0F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(60, 62).addBox(8.0F, -3.0F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(6.6F, -3.5F, 11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(5.6F, -2.5F, 11.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.6F, -1.5F, 12.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(3.6F, -0.5F, 12.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(2.6F, 0.5F, 13.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(1.6F, 1.5F, 13.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.6F, 2.5F, 14.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-0.4F, 3.5F, 14.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-1.0F, 4.0F, 13.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.2217F, 1.2217F, 0.0F);
		cube_r2.texOffs(0, 0).addBox(-1.0F, 4.0F, 12.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.1345F, 1.1345F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(-1.0F, 4.0F, 11.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.0472F, 1.0472F, 0.0F);
		cube_r4.texOffs(0, 0).addBox(-1.0F, 4.0F, 10.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.9599F, 0.9599F, 0.0F);
		cube_r5.texOffs(0, 0).addBox(-1.0F, 4.0F, 9.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.8727F, 0.8727F, 0.0F);
		cube_r6.texOffs(0, 0).addBox(-1.0F, 4.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.7854F, 0.7854F, 0.0F);
		cube_r7.texOffs(0, 0).addBox(-1.0F, 4.0F, 7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.6981F, 0.6981F, 0.0F);
		cube_r8.texOffs(0, 0).addBox(-1.0F, 4.0F, 6.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.6109F, 0.6109F, 0.0F);
		cube_r9.texOffs(0, 0).addBox(-1.0F, 4.0F, 5.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.5236F, 0.5236F, 0.0F);
		cube_r10.texOffs(0, 0).addBox(-1.0F, 4.0F, 4.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.4363F, 0.4363F, 0.0F);
		cube_r11.texOffs(0, 0).addBox(-1.0F, 4.0F, 3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.3491F, 0.3491F, 0.0F);
		cube_r12.texOffs(0, 0).addBox(-1.0F, 4.0F, 2.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 0.0F, 0.0F);
		chestplate.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.2618F, 0.2618F, 0.0F);
		cube_r13.texOffs(0, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Rarm = new ModelRenderer(this);
		Rarm.setPos(-5.0F, 2.0F, 0.0F);
		Rarm.texOffs(0, 62).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Rarm.texOffs(0, 61).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Rarm.texOffs(0, 58).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		Rarm.texOffs(44, 59).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rarm.texOffs(0, 61).addBox(-4.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Rarm.texOffs(0, 61).addBox(-3.0F, -2.0F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Rarm.texOffs(0, 62).addBox(-2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Larm = new ModelRenderer(this);
		Larm.setPos(5.0F, 2.0F, 0.0F);
		Larm.texOffs(0, 62).addBox(0.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Larm.texOffs(0, 61).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Larm.texOffs(44, 59).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Larm.texOffs(0, 58).addBox(3.0F, -2.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		Larm.texOffs(0, 61).addBox(3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Larm.texOffs(0, 61).addBox(-1.0F, -2.0F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Larm.texOffs(0, 62).addBox(0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		chestplate.render(matrixStack, buffer, packedLight, packedOverlay);
		Rarm.render(matrixStack, buffer, packedLight, packedOverlay);
		Larm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}