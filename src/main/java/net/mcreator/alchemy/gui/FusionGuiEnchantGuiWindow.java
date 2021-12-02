
package net.mcreator.alchemy.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.alchemy.AlchemyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FusionGuiEnchantGuiWindow extends ContainerScreen<FusionGuiEnchantGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = FusionGuiEnchantGui.guistate;
	CheckboxButton Enchant;
	CheckboxButton Unenchant;
	public FusionGuiEnchantGuiWindow(FusionGuiEnchantGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("alchemy:textures/fusion_gui_enchant.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/demo_background1.png"));
		this.blit(ms, this.guiLeft + -111, this.guiTop + 4, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/aaa.png"));
		this.blit(ms, this.guiLeft + -94, this.guiTop + 51, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/demo123.png"));
		this.blit(ms, this.guiLeft + -94, this.guiTop + 23, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/wadawdawawd.png"));
		this.blit(ms, this.guiLeft + 10, this.guiTop + 40, 0, 0, 20, 20, 20, 20);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/emerald_drawing.png"));
		this.blit(ms, this.guiLeft + 36, this.guiTop + 61, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/book1.png"));
		this.blit(ms, this.guiLeft + 36, this.guiTop + 22, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Your", 10, 23, -12829636);
		this.font.drawString(ms, "Tool", 10, 31, -12829636);
		this.font.drawString(ms, "Eme-", 34, 43, -12829636);
		this.font.drawString(ms, "ralds", 32, 51, -12829636);
		this.font.drawString(ms, "Book", 34, 12, -12829636);
		this.font.drawString(ms, "Or", 127, 46, -12829636);
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
		this.addButton(new Button(this.guiLeft + -67, this.guiTop + 21, 55, 20, new StringTextComponent("Fusion"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuiEnchantGui.ButtonPressedMessage(0, x, y, z));
				FusionGuiEnchantGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -67, this.guiTop + 49, 60, 20, new StringTextComponent("Enchant"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuiEnchantGui.ButtonPressedMessage(1, x, y, z));
				FusionGuiEnchantGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 59, 60, 20, new StringTextComponent("Enchant"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuiEnchantGui.ButtonPressedMessage(2, x, y, z));
				FusionGuiEnchantGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		Enchant = new CheckboxButton(this.guiLeft + 73, this.guiTop + 59, 150, 20, new StringTextComponent(""), false);
		FusionGuiEnchantGui.guistate.put("checkbox:Enchant", Enchant);
		this.addButton(Enchant);
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 20, 75, 20, new StringTextComponent("Un-Enchant"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new FusionGuiEnchantGui.ButtonPressedMessage(3, x, y, z));
				FusionGuiEnchantGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		Unenchant = new CheckboxButton(this.guiLeft + 73, this.guiTop + 20, 150, 20, new StringTextComponent(""), false);
		FusionGuiEnchantGui.guistate.put("checkbox:Unenchant", Unenchant);
		this.addButton(Unenchant);
	}
}
