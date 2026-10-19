# Copper Golem Reinforced Storage Compat

Server-side Fabric mod for **Minecraft 26.2**. Vanilla copper golems only deposit
items into vanilla chests and trapped chests (a hardcoded block check). This mod
widens that check so golems can also deposit into **Reinforced Chests** and
**Reinforced Barrels** (all tiers). The copper tier of Reinforced Chests stays
source-only, matching vanilla copper chests.

- Requires Fabric Loader 0.19.3+, Fabric API, Java 25.
- Server-side only; clients do not need it.
- Does nothing unless the reinforced chest/barrel mods (`reinfchest`, `reinfbarrel`)
  are installed. It matches them by registry namespace and has no code dependency on them.
- Patches a private static in `CopperGolemAi`, so it is tied to Minecraft 26.2 and may
  need a rebuild after Minecraft updates.

## Building

Requires JDK 25 (`JAVA_HOME`). `./gradlew build` — the jar lands in `build/libs/`.

## License

MIT, see [LICENSE](LICENSE).
