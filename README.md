# Copper Golem Reinforced Storage Compat

Server-side Fabric mod for **Minecraft 26.2**. Vanilla copper golems only deposit
items into vanilla chests and trapped chests (a hardcoded block check). This mod
widens that check so golems can also deposit into **Reinforced Chests** and
**Reinforced Barrels** (all tiers). The copper tier of Reinforced Chests stays
source-only, matching vanilla copper chests.

- Requires Fabric Loader 0.19.5+ (the community port's minimum), Fabric API, Java 25.
- Dedicated server only; clients do not need it, and it does not load in singleplayer.
- Does nothing unless the reinforced chest/barrel mods (`reinfchest`, `reinfbarrel`)
  are installed. It matches them by registry namespace and has no code dependency on them.
- Patches a private static in `CopperGolemAi`, so it is tied to Minecraft 26.2 and may
  need a rebuild after Minecraft updates.

## Reinforced Chests and Barrels on 26.2

The original mods by Aton-Kish have no official 26.2 release. This mod targets the
[unofficial community 26.2 port](https://github.com/mavrikakis9099-boop/reinforced-storage-26-2-community-port/releases),
which keeps the original block IDs. It is not affiliated with this project or with Aton-Kish.
Original mods: [reinforced-chests](https://github.com/Aton-Kish/reinforced-chests),
[reinforced-barrels](https://github.com/Aton-Kish/reinforced-barrels). Review the port yourself
before installing it, as with any mod from outside Modrinth.

## Building

Requires JDK 25 (`JAVA_HOME`). `./gradlew build` — the jar lands in `build/libs/`.

## License

MIT, see [LICENSE](LICENSE).
