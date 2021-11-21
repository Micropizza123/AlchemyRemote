
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
public class ItemGuideP2GuiWindow extends ContainerScreen<ItemGuideP2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ItemGuideP2Gui.guistate;
	public ItemGuideP2GuiWindow(ItemGuideP2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/lava_bucket.png"));
		this.blit(ms, this.guiLeft + 110, this.guiTop + -4, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/lava_still.png"));
		this.blit(ms, this.guiLeft + 41, this.guiTop + -4, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Cold Lava", 62, -2, -13421773);
		this.font.drawString(ms, "Cold lava is a Fluid", 27, 14, -13421773);
		this.font.drawString(ms, "that is like lava but", 27, 24, -13421773);
		this.font.drawString(ms, "colded.", 28, 34, -13421773);
		this.font.drawString(ms, "Cold Lava is used as a", 27, 43, -13421773);
		this.font.drawString(ms, "fuel on furnaces even on", 26, 52, -13421773);
		this.font.drawString(ms, "fusion furnace where it", 26, 60, -13421773);
		this.font.drawString(ms, "is made on.", 26, 68, -13421773);
		this.font.drawString(ms, "Cold Lava is 4 times", 25, 76, -13421773);
		this.font.drawString(ms, "better than lava as a", 26, 85, -13421773);
		this.font.drawString(ms, "fuel.", 25, 94, -13421773);
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
		this.addButton(new Button(this.guiLeft + 157, this.guiTop + 146, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new ItemGuideP2Gui.ButtonPressedMessage(0, x, y, z));
				ItemGuideP2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -12, this.guiTop + 146, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new ItemGuideP2Gui.ButtonPressedMessage(1, x, y, z));
				ItemGuideP2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
