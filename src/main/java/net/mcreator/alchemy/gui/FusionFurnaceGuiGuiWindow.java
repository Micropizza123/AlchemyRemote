
package net.mcreator.alchemy.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.alchemy.procedures.ProgressbarEmptyProcedure;
import net.mcreator.alchemy.procedures.Progress9Procedure;
import net.mcreator.alchemy.procedures.Progress8Procedure;
import net.mcreator.alchemy.procedures.Progress7Procedure;
import net.mcreator.alchemy.procedures.Progress6Procedure;
import net.mcreator.alchemy.procedures.Progress5Procedure;
import net.mcreator.alchemy.procedures.Progress4Procedure;
import net.mcreator.alchemy.procedures.Progress3Procedure;
import net.mcreator.alchemy.procedures.Progress2Procedure;
import net.mcreator.alchemy.procedures.Progress10Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class FusionFurnaceGuiGuiWindow extends ContainerScreen<FusionFurnaceGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = FusionFurnaceGuiGui.guistate;
	public FusionFurnaceGuiGuiWindow(FusionFurnaceGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("alchemy:textures/fusion_furnace_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_empty.png"));
		this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		if (ProgressbarEmptyProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_0.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_1.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_2.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_3.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_4.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_5.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_6.png"));
			this.blit(ms, this.guiLeft + 41, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_7.png"));
			this.blit(ms, this.guiLeft + 40, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_8.png"));
			this.blit(ms, this.guiLeft + 40, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		if (Progress10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_9.png"));
			this.blit(ms, this.guiLeft + 40, this.guiTop + 36, 0, 0, 54, 10, 54, 10);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
