package com.andpeterson.twtutorial.init;

import java.util.function.Supplier;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.TWtutorial.TWtutorialItemGroup;
import com.andpeterson.twtutorial.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TWtutorial.MOD_ID);
	
	public static final RegistryObject<SpecialItem> DEF_ITEMS = ITEMS.register("def_item", () -> new SpecialItem(new Item.Properties().group(TWtutorialItemGroup.instance)));
	
	// Items
	public static final RegistryObject<Item> ITEM_ONE = ITEMS.register("item_one", () -> new Item(new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> ITEM_TWO = ITEMS.register("item_two", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> ANDPETERSON_TABLET = ITEMS.register("andpeterson_tablet", () -> new Item(new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food", () -> new Item(new Item.Properties().group(TWtutorialItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> SPECIAL_ITEM = ITEMS.register("special_item", () -> new SpecialItem(new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> NEW_TOOL_NAME = ITEMS.register("new_tool_name", () -> new SpecialItem(new Item.Properties().group(TWtutorialItemGroup.instance)));
	
	// Tools
	public static final RegistryObject<Item> EXAMPLE_SWORD = ITEMS.register("example_sword", () -> new SwordItem(ModItemTier.EXAMPLE, 7, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe", () -> new PickaxeItem(ModItemTier.EXAMPLE, 4, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> EXAMPLE_SHOVEL = ITEMS.register("example_shovel", () -> new ShovelItem(ModItemTier.EXAMPLE, 2, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> EXAMPLE_AXE = ITEMS.register("example_axe", () -> new AxeItem(ModItemTier.EXAMPLE, 11, 2.5F, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> EXAMPLE_HOE = ITEMS.register("example_hoe", () -> new HoeItem(ModItemTier.EXAMPLE, 5.0f, new Item.Properties().group(TWtutorialItemGroup.instance)));
	
	// Armor
	public static final RegistryObject<Item> TEST_HELMET = ITEMS.register("test_helmet", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> TEST_CHESTPLATE = ITEMS.register("test_chestplate", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> TEST_LEGGINGS = ITEMS.register("test_leggings", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(TWtutorialItemGroup.instance)));
	public static final RegistryObject<Item> TEST_BOOTS = ITEMS.register("test_boots", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(TWtutorialItemGroup.instance)));

	
	public enum ModItemTier implements IItemTier {
		
		// int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		EXAMPLE(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.ITEM_ONE.get());
		});
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}


		@Override
		public int getMaxUses() {
			return this.maxUses;
		}


		@Override
		public float getEfficiency() {
			return this.efficiency;
		}


		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}


		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}


		@Override
		public int getEnchantability() {
			return this.enchantability;
		}


		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	
	public enum ModArmorMaterial implements IArmorMaterial {
		// name, max_dmg_factor, dmg_reduction_amt, 
		TEST(TWtutorial.MOD_ID + ":test", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.ITEM_ONE.get());
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
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
