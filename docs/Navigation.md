```bash
.
├── ...
├── java ...            
│   ├── events              # 
│   ├── init                # Initalize and register new assets
│   ├── objects             # Object code and behaviour
│   ├── util
│   │   └── helpers         # Helpers for things like keyboard events
│   ├── worlds              # 
│   └── MOD.java            # Initalize mod and modEventBus
├── resources  
│   ├── assets ...
│   │   ├── blockstates     # Links blockstates to block models
│   │   ├── events          # Creates events off of the event bus
│   │   ├── lang            # Defines translations
│   │   ├── models          # Links models to textures
│   │   └── textures        # Textures to render for assets
│   ├── data ...
│   │   ├── loot_tables     # Defines what happens when a block breaks
│   │   ├── tags            # Creates a tag to group different assets together
│   ├── META-INF
│   │   └── mods.toml       # Defines mod meta such as mod_id, logo, url ect...
│   └── pack.mcmeta         # Defines pack meta such as desc and format
└── ...
```