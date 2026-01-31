package net.goldtreeservers.worldguardextraflags.listeners;

import com.destroystokyo.paper.event.player.PlayerInitialSpawnEvent;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import lombok.RequiredArgsConstructor;
import net.goldtreeservers.worldguardextraflags.WorldGuardExtraFlagsPlugin;
import net.goldtreeservers.worldguardextraflags.flags.Flags;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class PaperPlayerListener implements Listener {
    private final WorldGuardExtraFlagsPlugin plugin;
    private final RegionContainer regionContainer;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerSpawnLocationEvent(PlayerInitialSpawnEvent event) {
        Player player = event.getPlayer();
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);

        Location location = this.regionContainer.createQuery().queryValue(BukkitAdapter.adapt(event.getSpawnLocation()),
                localPlayer, Flags.JOIN_LOCATION);
        if (location != null) {
            event.setSpawnLocation(BukkitAdapter.adapt(location));
        }
    }
}
