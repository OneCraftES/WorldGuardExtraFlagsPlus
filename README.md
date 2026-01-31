# WorldGuard ExtraFlags

A Bukkit plugin extension that provides extra flags for [WorldGuard](https://github.com/EngineHub/WorldGuard).

This is a fork that adds more flags that are needed in the official OneCraft server.

## About
WorldGuard allows protecting areas of land by the creation of regions which then can be customized further by applying special flags. WorldGuard provides an API that 3th party plugins can use to provide their own flags.

This plugin adds extra flags to allow customizing regions even further.

## New Flags

### damage-mobs
Controls whether players can damage non-player entities (mobs) in the region.
- Type: State flag (ALLOW/DENY)
- Default: DENY
- Example: `/rg flag <region> damage-mobs deny`

This flag prevents players from damaging any non-player entities within the region when set to DENY. When set to ALLOW, players can damage mobs normally. This is useful for creating safe zones for mobs or areas where players should not interfere with creatures. In OneCraft, we use it to prevent non-members from damaging mobs in player's regions as we find it a form of griefing.

### disable-collisions
Controls whether entities can collide with each other in the region.
- Type: State flag (ALLOW/DENY)
- Default: DENY
- Example: `/rg flag <region> disable-collisions allow`

This flag disables entity collisions within the region when set to ALLOW. When set to DENY (default), normal collision mechanics apply. This is useful for areas where you want to prevent entity pushing/bumping, such as spawn points, parkour areas, or crowded zones. The flag affects all types of entity collisions, not just player-to-player collisions.

This feature was inspired by and based on [WorldGuardDisableCollision](https://github.com/magrigry/WorldGuardDisableCollision), integrated into WorldGuardExtraFlags for convenience.

### lava-damage
Controls whether entities take damage from lava in the region.
- Type: State flag (ALLOW/DENY)
- Default: ALLOW (Lava damage is enabled by default)
- Example: `/rg flag <region> lava-damage deny`

This flag prevents entities from taking damage from lava when set to DENY. It also prevents entities from catching fire when entering lava, so they won't burn after exiting. This is useful for creating safe lava parkour areas or decorative lava features.

## More
Download and usage are provided on the corresponding [Spigot page](https://www.spigotmc.org/resources/worldguard-extra-flags.4823/)
