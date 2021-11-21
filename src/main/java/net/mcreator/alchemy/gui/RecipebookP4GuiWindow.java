
package net.mcreator.alchemy.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.alchemy.AlchemyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RecipebookP4GuiWindow extends ContainerScreen<RecipebookP4Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = RecipebookP4Gui.guistate;
	public RecipebookP4GuiWindow(RecipebookP4Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/book.png"));
		this.blit(ms, this.guiLeft + -5, this.guiTop + -21, 0, 0, 200, 200, 200, 200);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/bibelssi.png"));
		this.blit(ms, this.guiLeft + 26, this.guiTop + 8, 0, 0, 119, 48, 119, 48);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/progress_bar_filled_6.png"));
		this.blit(ms, this.guiLeft + 58, this.guiTop + 26, 0, 0, 54, 10, 54, 10);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/reallava.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 38, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/grid_obsidian_ingot.png"));
		this.blit(ms, this.guiLeft + 128, this.guiTop + 10, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/obsidianblock.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 10, 0, 0, 15, 15, 15, 15);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/bibelssi.png"));
		this.blit(ms, this.guiLeft + 26, this.guiTop + 65, 0, 0, 119, 48, 119, 48);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/diamond.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 95, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/bonemeal.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 67, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/white_diamond.png"));
		this.blit(ms, this.guiLeft + 128, this.guiTop + 95, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Obsidian Ingot", 46, -3, -13421773);
		this.font.drawString(ms, "White Diamond", 49, 54, -13421773);
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
		this.addButton(new Button(this.guiLeft + -12, this.guiTop + 146, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new RecipebookP4Gui.ButtonPressedMessage(0, x, y, z));
				RecipebookP4Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 157, this.guiTop + 146, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new RecipebookP4Gui.ButtonPressedMessage(1, x, y, z));
				RecipebookP4Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
