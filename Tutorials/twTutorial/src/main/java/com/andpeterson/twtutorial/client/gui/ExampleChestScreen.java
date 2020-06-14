package com.andpeterson.twtutorial.client.gui;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.container.ExampleChestContainer;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer> {

	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(TWtutorial.MOD_ID, "textures/gui/example_chest.png");
	
	// positions
	private int textColor = 4210752;
	private float titleTextX = 8.0f;
	private float titleTextY = 6.0f;
	private float piTextX = 8.0f;
	private float piTextY = 90.0f;
	
	public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 183;
	}
	
	@Override
	public void render(final int mouseX, final int mouseY, final float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.font.drawString(this.title.getFormattedText(), titleTextX, titleTextY, textColor); //title
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), piTextX, piTextY, textColor); //pi 
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// RGBA
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.blit(x, y, 0, 0, this.xSize, this.ySize);
	}
}
