package com.andpeterson.mythril_ore.init;

import java.util.function.Supplier;

import com.andpeterson.mythril_ore.MythrilOre;
import com.andpeterson.mythril_ore.objects.items.MythrilItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = MythrilOre.MOD_ID, bus = Bus.MOD)
@ObjectHolder(MythrilOre.MOD_ID)
public class ItemInit {
	
	//Define Items
	public static final Item Mythril = null;
	public static final Item MythrilSword = null;
	public static final Item MythrilShovel = null;
	public static final Item MythrilPickaxe = null;
	public static final Item MythrilAxe = null;
	public static final Item MythrilHoe = null;
	//@@Define
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		//Register Items
/*
      public static final Item DIAMOND_SWORD = register("diamond_sword", new SwordItem(ItemTier.DIAMOND, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	  public static final Item DIAMOND_SHOVEL = register("diamond_shovel", new ShovelItem(ItemTier.DIAMOND, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	  public static final Item DIAMOND_PICKAXE = register("diamond_pickaxe", new PickaxeItem(ItemTier.DIAMOND, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	  public static final Item DIAMOND_AXE = register("diamond_axe", new AxeItem(ItemTier.DIAMOND, 5.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	  public static final Item DIAMOND_HOE = register("diamond_hoe", new HoeItem(ItemTier.DIAMOND, 0.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
 */
		event.getRegistry().register(new MythrilItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("mythril"));
		// Tier, Dmg, Spd
		event.getRegistry().register(new SwordItem(MythrilItemTier.MYTHRIL, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_sword"));
		event.getRegistry().register(new ShovelItem(MythrilItemTier.MYTHRIL, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_shovel"));
		event.getRegistry().register(new PickaxeItem(MythrilItemTier.MYTHRIL, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_pickaxe"));
		event.getRegistry().register(new AxeItem(MythrilItemTier.MYTHRIL, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_axe"));
		event.getRegistry().register(new HoeItem(MythrilItemTier.MYTHRIL, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_hoe"));
		//@@Register
	}
	
	public enum MythrilItemTier implements IItemTier {
		
		// int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		MYTHRIL(3, 32, 8.0F, 3.0F, 10, () -> {
			return Ingredient.fromItems(ItemInit.Mythril);
		});
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private MythrilItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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
			return this.repairMaterial.getValue()
;		}
		
	}
}