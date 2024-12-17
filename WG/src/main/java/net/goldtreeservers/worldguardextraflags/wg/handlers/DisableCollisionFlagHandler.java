package net.goldtreeservers.worldguardextraflags.wg.handlers;

import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.session.MoveType;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;
import com.sk89q.worldguard.session.handler.FlagValueChangeHandler;
import net.goldtreeservers.worldguardextraflags.flags.Flags;
import net.goldtreeservers.worldguardextraflags.utils.CollisionManager;
import org.bukkit.entity.Player;
import com.sk89q.worldguard.bukkit.BukkitPlayer;

public class DisableCollisionFlagHandler extends FlagValueChangeHandler<State> {
    public static final Factory FACTORY = new Factory();
    public static class Factory extends Handler.Factory<DisableCollisionFlagHandler> {
        @Override
        public DisableCollisionFlagHandler create(Session session) {
            return new DisableCollisionFlagHandler(session);
        }
    }

    protected DisableCollisionFlagHandler(Session session) {
        super(session, Flags.DISABLE_COLLISIONS);
    }

    @Override
    protected void onInitialValue(LocalPlayer player, ApplicableRegionSet set, State value) {
        this.handleValue(player, value);
    }

    @Override
    protected boolean onSetValue(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet, State currentValue, State lastValue, MoveType moveType) {
        this.handleValue(player, currentValue);
        return true;
    }

    @Override
    protected boolean onAbsentValue(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet, State lastValue, MoveType moveType) {
        this.handleValue(player, null);
        return true;
    }

    private void handleValue(LocalPlayer player, State value) {
        Player bukkitPlayer = ((BukkitPlayer)player).getPlayer();
        
        if (value == State.ALLOW) {
            CollisionManager.addPlayer(bukkitPlayer);
        } else if (CollisionManager.containsPlayer(bukkitPlayer)) {
            CollisionManager.removePlayer(bukkitPlayer);
        }
    }
}
