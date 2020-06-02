# Creating A New Mod
## Modding Setup
1. create a new folder with the mods name
1. copy over the contents of `./resources/forge-1.x-mdk`
1. run `gradlew genEclipseRuns` and `gradlew eclipse`
1. add new gradle project in Eclipse workspace that points to new Gradle Project
1. update `src/main/resources/META-INF/mods.toml`
1. update name in `com.andpeterson.examplemod`
1. update `com.andpeterson.examplemod.ExampleMod`

## Environment Setup
### Eclipse

## Live Reload Resources
` F3 + t `

## Eclipse shortcuts
`Ctrl + Space` - Eclipse Context Suggestions

## Useful Links
- Loot Tables: https://minecraft.gamepedia.com/Loot_table
- Color Codes: https://www.digminecraft.com/lists/color_list_pc.php

### Tags
- Minecraft tags: https://minecraft.gamepedia.com/Tag#JSON_format
- Forge Tags: https://mcforge.readthedocs.io/en/latest/utilities/tags/