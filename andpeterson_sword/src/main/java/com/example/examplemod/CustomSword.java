package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

	public CustomSword() {
		super(ExampleMod.myToolMaterial);
		// TODO Auto-generated constructor stub
		this.setRegistryName("studded_iron_sword");
		this.setUnlocalizedName("studded_iron_sword");
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

}
