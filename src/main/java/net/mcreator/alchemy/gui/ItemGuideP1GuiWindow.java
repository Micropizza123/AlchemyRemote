
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
public class ItemGuideP1GuiWindow extends ContainerScreen<ItemGuideP1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ItemGuideP1Gui.guistate;
	public ItemGuideP1GuiWindow(ItemGuideP1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/nimeton.png"));
		this.blit(ms, this.guiLeft + 40, this.guiTop + 28, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/nimeton2.png"));
		this.blit(ms, this.guiLeft + 55, this.guiTop + 28, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/nimeton3.png"));
		this.blit(ms, this.guiLeft + 70, this.guiTop + 28, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/nimeton4.png"));
		this.blit(ms, this.guiLeft + 87, this.guiTop + 29, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/nimeton5.png"));
		this.blit(ms, this.guiLeft + 102, this.guiTop + 28, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/1.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 73, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/2.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 88, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/3.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 104, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/4.png"));
		this.blit(ms, this.guiLeft + 28, this.guiTop + 118, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/5.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 134, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/awda.png"));
		this.blit(ms, this.guiLeft + 53, this.guiTop + 74, 0, 0, 2, 80, 2, 80);
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
		this.font.drawString(ms, "Item Guide", 57, 0, -16777216);
		this.font.drawString(ms, "Runes", 68, 17, -13421773);
		this.font.drawString(ms, "Can be found in chests.", 31, 45, -13421773);
		this.font.drawString(ms, "Every rune is used to", 31, 54, -13421773);
		this.font.drawString(ms, "do different things.", 31, 64, -13421773);
		this.font.drawString(ms, "\u00DC", 68, 120, -13421773);
		this.font.drawString(ms, "L", 68, 105, -13421773);
		this.font.drawString(ms, "LI", 66, 75, -13421773);
		this.font.drawString(ms, "Y", 68, 136, -13421773);
		this.font.drawString(ms, "iL", 66, 90, -13421773);
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
				AlchemyMod.PACKET_HANDLER.sendToServer(new ItemGuideP1Gui.ButtonPressedMessage(0, x, y, z));
				ItemGuideP1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 157, this.guiTop + 146, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new ItemGuideP1Gui.ButtonPressedMessage(1, x, y, z));
				ItemGuideP1Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
