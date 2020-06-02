package com.andpeterson.mythril_ore.init;

import java.util.function.Supplier;

import com.andpeterson.mythril_ore.MythrilOre;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitDeferred {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MythrilOre.MOD_ID);
	
	
	public static final RegistryObject<Item> MYTHRIL_HELMET = ITEMS.register("mythril_helmet", () -> new ArmorItem(
			MythrilArmorMaterial.MYTHRIL, 
			EquipmentSlotType.HEAD, 
			new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> MYTHRIL_CHESTPLATE = ITEMS.register("mythril_chestplate", () -> new ArmorItem(
			MythrilArmorMaterial.MYTHRIL, 
			EquipmentSlotType.CHEST, 
			new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> MYTHRIL_LEGGINGS = ITEMS.register("mythril_leggings", () -> new ArmorItem(
			MythrilArmorMaterial.MYTHRIL, 
			EquipmentSlotType.LEGS, 
			new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> DEF_ITEMYTHRIL_BOOTS = ITEMS.register("mythril_boots", () -> new ArmorItem(
			MythrilArmorMaterial.MYTHRIL, 
			EquipmentSlotType.FEET, 
			new Item.Properties().group(ItemGroup.MISC)));
	
//	DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
//	      return Ingredient.fromItems(Items.DIAMOND);
//	   }),
	public enum MythrilArmorMaterial implements IArmorMaterial {
		// name, max_dmg_factor, dmg_reduction_amt, ?, sound, ?
		MYTHRIL(MythrilOre.MOD_ID + ":mythril", 50, new int[] { 7, 9, 11, 7 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
			return Ingredient.fromItems(ItemInit.Mythril);
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private MythrilArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}
		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}
		@Override
		public int getEnchantability() {
			return this.enchantability;
		}
		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}
		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
