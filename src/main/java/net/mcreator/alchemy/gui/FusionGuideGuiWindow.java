
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
public class FusionGuideGuiWindow extends ContainerScreen<FusionGuideGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = FusionGuideGui.guistate;
	public FusionGuideGuiWindow(FusionGuideGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		this.font.drawString(ms, "Alchemy Guide", 51, -5, -13421773);
		this.font.drawString(ms, "Key to everything...", 37, 3, -13421773);
		this.font.drawString(ms, "Tip:", 27, 86, -13421773);
		this.font.drawString(ms, " press r to see abilities", 22, 96, -13421773);
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
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 23, 85, 20, new StringTextComponent("Open Recipes"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuideGui.ButtonPressedMessage(0, x, y, z));
				FusionGuideGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 35, this.guiTop + 44, 100, 20, new StringTextComponent("Open Item Guide"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuideGui.ButtonPressedMessage(1, x, y, z));
				FusionGuideGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 38, this.guiTop + 65, 95, 20, new StringTextComponent("About Ablanian"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuideGui.ButtonPressedMessage(2, x, y, z));
				FusionGuideGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
