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

## More
Download and usage are provided on the corresponding [Spigot page](https://www.spigotmc.org/resources/worldguard-extra-flags.4823/)
