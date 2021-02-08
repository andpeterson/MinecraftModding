package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.entity.PassiveEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TWtutorial.MOD_ID);
	
	public static final RegistryObject<EntityType<PassiveEntity>> PASSIVE_ENTITY = ENTITY_TYPES.register("passive_entity", EntityType.Builder.<PassiveEntity>create(PassiveEntity::new, EntityClassification.CREATURE).size(0.9f, 1.3f).build(new ResourceLocation(TWtutorial.MOD_ID, "passive_entity").toString()))
}
