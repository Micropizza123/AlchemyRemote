
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

import net.mcreator.alchemy.procedures.WarpingPearlInInventoryProcedure;
import net.mcreator.alchemy.procedures.StrenghtinInventoryProcedure;
import net.mcreator.alchemy.procedures.SpellBookInInvetoryProcedure;
import net.mcreator.alchemy.procedures.LifeInInvetoryProcedure;
import net.mcreator.alchemy.procedures.FlightOnProcedure;
import net.mcreator.alchemy.procedures.DefenceInInvetoryProcedure;
import net.mcreator.alchemy.AlchemyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class AbilitiesGuiGuiWindow extends ContainerScreen<AbilitiesGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AbilitiesGuiGui.guistate;
	public AbilitiesGuiGuiWindow(AbilitiesGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/map_background.png"));
		this.blit(ms, this.guiLeft + 12, this.guiTop + 9, 0, 0, 150, 150, 150, 150);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/mapthinh.png"));
		this.blit(ms, this.guiLeft + -124, this.guiTop + -36, 0, 0, 100, 100, 100, 100);
		if (StrenghtinInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/potion_of_damage.png"));
			this.blit(ms, this.guiLeft + -118, this.guiTop + -24, 0, 0, 16, 16, 16, 16);
		}
		if (DefenceInInvetoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/potion_of_defence.png"));
			this.blit(ms, this.guiLeft + -107, this.guiTop + -24, 0, 0, 16, 16, 16, 16);
		}
		if (LifeInInvetoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/potion_of_life.png"));
			this.blit(ms, this.guiLeft + -96, this.guiTop + -24, 0, 0, 16, 16, 16, 16);
		}
		if (FlightOnProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/pixelartwings.png"));
			this.blit(ms, this.guiLeft + -82, this.guiTop + -29, 0, 0, 28, 28, 28, 28);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy:textures/mapthinh.png"));
		this.blit(ms, this.guiLeft + -124, this.guiTop + 64, 0, 0, 100, 100, 100, 100);
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
		this.font.drawString(ms, "Abilities", 63, 20, -13421773);
		if (WarpingPearlInInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "WarpingPearl", 19, 31, -13421773);
		this.font.drawString(ms, "Passive Abilities", -116, -32, -13421773);
		this.font.drawString(ms, "Permanent modding", -118, 72, -13421773);
		this.font.drawString(ms, "Spellbook", -99, 21, -13421773);
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
		this.addButton(new Button(this.guiLeft + 18, this.guiTop + 43, 85, 20, new StringTextComponent("Set Location"), e -> {
			if (WarpingPearlInInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new AbilitiesGuiGui.ButtonPressedMessage(0, x, y, z));
				AbilitiesGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (WarpingPearlInInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 18, this.guiTop + 64, 65, 20, new StringTextComponent("Teleport"), e -> {
			if (WarpingPearlInInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new AbilitiesGuiGui.ButtonPressedMessage(1, x, y, z));
				AbilitiesGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (WarpingPearlInInventoryProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -120, this.guiTop + 84, 90, 20, new StringTextComponent("Permanent Mods"), e -> {
			if (true) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new AbilitiesGuiGui.ButtonPressedMessage(2, x, y, z));
				AbilitiesGuiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -111, this.guiTop + 33, 70, 20, new StringTextComponent("SpellBook"), e -> {
			if (SpellBookInInvetoryProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				AlchemyMod.PACKET_HANDLER.sendToServer(new AbilitiesGuiGui.ButtonPressedMessage(3, x, y, z));
				AbilitiesGuiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (SpellBookInInvetoryProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
