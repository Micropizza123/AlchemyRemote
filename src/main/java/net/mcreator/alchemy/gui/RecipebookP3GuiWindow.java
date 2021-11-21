
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
public class RecipebookP3GuiWindow extends ContainerScreen<RecipebookP3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = RecipebookP3Gui.guistate;
	public RecipebookP3GuiWindow(RecipebookP3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/juttu.png"));
		this.blit(ms, this.guiLeft + 34, this.guiTop + 15, 0, 0, 108, 54, 108, 54);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/qwerdsa.png"));
		this.blit(ms, this.guiLeft + 53, this.guiTop + 16, 0, 0, 15, 15, 15, 15);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/qwerdsa.png"));
		this.blit(ms, this.guiLeft + 35, this.guiTop + 34, 0, 0, 15, 15, 15, 15);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/qwerdsa.png"));
		this.blit(ms, this.guiLeft + 71, this.guiTop + 34, 0, 0, 15, 15, 15, 15);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/qwerdsa.png"));
		this.blit(ms, this.guiLeft + 53, this.guiTop + 52, 0, 0, 15, 15, 15, 15);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/icepowder.png"));
		this.blit(ms, this.guiLeft + 125, this.guiTop + 33, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Ice Element", 56, -1, -13421773);
		this.font.drawString(ms, "Must have gotten Water's", 26, 69, -13421773);
		this.font.drawString(ms, "Spellbook alteast once.", 26, 78, -13421773);
		this.font.drawString(ms, "To craft Ice element you ", 26, 87, -13421773);
		this.font.drawString(ms, "Need normal ice.", 27, 95, -13421773);
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
				AlchemyMod.PACKET_HANDLER.sendToServer(new RecipebookP3Gui.ButtonPressedMessage(0, x, y, z));
				RecipebookP3Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 157, this.guiTop + 146, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new RecipebookP3Gui.ButtonPressedMessage(1, x, y, z));
				RecipebookP3Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
