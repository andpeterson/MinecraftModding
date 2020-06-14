package com.andpeterson.twtutorial.container;

import java.util.Objects;

import com.andpeterson.twtutorial.init.BlockInit;
import com.andpeterson.twtutorial.init.ModContainerTypes;
import com.andpeterson.twtutorial.init.NewBlockInit;
import com.andpeterson.twtutorial.tileentity.ExampleChestTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class ExampleChestContainer extends Container {
	public final ExampleChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	
	public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory, final ExampleChestTileEntity tileEntity) {
		super(ModContainerTypes.EXAMPLE_CHEST.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		//Main Inventory
		int startX = 8; // slot's pixel x pos
		int startY = 18; // slot's pixel y pos
		int slotSize = 16 + 2;
		for(int row = 0; row < 4; ++row) {
			for(int col = 0; col < 9; ++col) {
				int index = (row*9) + col;
				int posX = startX + (col * slotSize);
				int posY = startY + (row * slotSize);
				this.addSlot(new Slot(tileEntity, index, posX, posY));
				
			}
		}
		
		//Main Player Inventory
		int startPlayerInvY = startY * 5 + 12; //should probably base this off of slotSize
		for(int row = 0; row < 3; ++row) {
			for(int col = 0; col < 9; ++col) {
				int index = 9 + (row * 9) + col;
				int posX = startX + (col * slotSize);
				int posY = startY + (row * slotSize);
				this.addSlot(new Slot(playerInventory, index, posX, posY));
			}
		}
		
		//Hotbar Inventory
		int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
		for(int col = 0; col < 9; ++col) {
			int index = startX + (col * slotSize);
			int posX = startX + (col * slotSize);
			this.addSlot(new Slot(playerInventory, index, posX, hotbarY));
		}
	}
	
	private static ExampleChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof ExampleChestTileEntity) {
			return (ExampleChestTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct!" + tileAtPos);
	}
	
	public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, NewBlockInit.EXAMPLE_CHEST.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			itemstack = itemstack1.copy();
			if(index < 36) {
				if(!this.mergeItemStack(itemstack1, 36, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
				else if(!this.mergeItemStack(itemstack1, 0, 36, false)) {
					return ItemStack.EMPTY;
				}
			}
			if(itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}
