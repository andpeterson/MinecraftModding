# Adding
Here's how to add all kinds of different things to the game

Registering a new asset:
```Java
event.getRegistry().register(NEW_ASSET)
```

## Terms
- DURATION - measured in ticks (20 ticks = 1 sec)
- PROBABLITY - (0.0f - 1.0f)

## Items
Command: newItem
Files:
- resources/assets.ID.models.item.NAME.json
- resources/assets.ID.lang.en_us.json
- resources/assets.ID.textures.items.NAME.png
- java/com.andpeterson.ID.init.ItemInit.java

Init:
`/init/ItemInit.java`
```Java
new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(NAME);
```

Code:
```Java
public class SpecialItem extends Item{
	public SpecialItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean someMethod() {
		return null;
	}
```

### Item Properties
#### Food
```Java
new Item.Properties().food(new FoodBuilder())
```
- `.hunger` - 1 fills half a drumstick
- `.saturation` - hunger you can't see (yellow outline)
- `.meat` - wolves can eat it
- `.fastToEat` - fast to eat food
- `.setAlwaysEdible` - Player can alyways eat food (even full hunger)
- `.effect` - `(new EffectInstance(Effects.EFFECTS, DURATION, AMPLIFIER), PROBABLITY).build()`

## Blocks
Command: newBlock
Files:
- resources/assets.ID.models.item.NAME.json
- resources/assets.ID.models.block.NAME.json
- resources/assets.ID.models.blockstates.NAME.json
- resources/assets.ID.lang.en_us.json
- resources/assets.ID.textures.blocks.NAME.png
- java/com.andpeterson.ID.init.BlockInit.java

Init:
`/init/BlockInit.java`
```Java
// Block
new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)).setRegistryName(NAME);
// ItemBlock
new BlockItem(NAME, new Item.Properties().maxStackSize(16).group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(NAME);
```

### OreGen
examples in: `net.minecraft.world.biome.DefaultBiomeFeatures.class`
`/world/gen/ORE.java`
```Java
public class TutorialOreGen {
	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			if(biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maximum));
			}
		}
	}
}
// count = how common (20 = really common)
// bottomOffset = offset from the bottom of the world
// topOffset = offset from the top of the world
// maximum = max height that ore generates in (max - height)
```

## New Creative Tab
Files:
- java/com.ORG.ID.MOD.java

`MOD.java`
```java
 public static class TWtutorialItemGroup extends ItemGroup {
    public static final TWtutorialItemGroup instance = new TWtutorialItemGroup(ItemGroup.GROUPS.length, "twtutorialtab");
    private TWtutorialItemGroup(int index, String label) {
      super(index, label);
    }
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ItemInit.AndpetersonTablet);
    }
  }
```

## Tags
`resources/data/MOD/tags/TYPE/TAG/json`
```JSON
{
  "replace": false,
  "values": [
    "minecraft:anvil",
    "minecraft:chipped_anvil",
    "minecraft:damaged_anvil",
    "twtutorial:example_block"
  ]
}
```
```Java
  ResourceLocation tagItem = new ResourceLocation(ID, "tag_item");
  Item item = ItemInit.itemOne;
  boolean isInTag = ItemTag.getCollection().get(tagItem).contains(item)
```

## Events
Files:
- assets/.../events/EVENT.java

```Java
// @Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent {
	
	@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event){
		TWtutorial.LOGGER.info("TestJumpEvent fired");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		world.setBlockState(livingEntity.getPosition().add(0,5,0), BlockInit.example_block.getDefaultState());
		livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 60, 255));
		livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 60, 255));
		livingEntity.setGlowing(true);
	}
}
```

### Sound Events
`net.minecraft.util.SoundEvents.class`