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
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TWtutorial.MOD_ID)
public class ItemInit {
	
	//Define Items
	public static final Item itemOne = null;
	public static final Item itemTwo = null;
	public static final Item AndpetersonTablet = null;
	public static final Item NewItemEight = null;
	public static final Item ExampleFood = null;
	public static final Item SpecialItem = null;
	
	//Tools
	public static final Item ExampleSword = null;
	public static final Item ExamplePickax = null;
	public static final Item ExampleShavel = null;
	public static final Item ExampleAx = null;
	public static final Item ExampleHoe = null;
	public static final Item NewToolName = null;
	//@@Define
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		//Register Items
		event.getRegistry().register(new Item(new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("item_one"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("item_two"));
		event.getRegistry().register(new Item(new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("andpeterson_tablet"));
		event.getRegistry().register(new Item(new Item.Properties().group(TWtutorialItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())).setRegistryName("example_food"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("special_item"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("example_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 4, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("example_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE, 2, 3.5F, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("example_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 11, 2.5F, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("example_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 5.0f, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("example_hoe"));
		event.getRegistry().register(new SwordItem(ItemTier.WOOD, 1, 1.0F, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("new_tool_name"));
		
		// Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("test_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("test_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("test_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("test_boots"));
		//@@Register
	}
	
	public enum ModItemTier implements IItemTier {
		
		// int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		EXAMPLE(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.itemOne);
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
			return Ingredient.fromItems(ItemInit.itemOne);
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