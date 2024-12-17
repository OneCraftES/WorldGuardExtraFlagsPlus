package net.goldtreeservers.worldguardextraflags.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CollisionManager {
    private static Team team;
    private static final String TEAM_NAME = "wgef_no_collision";

    public static void initialize() {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        
        if (board.getTeam(TEAM_NAME) == null) {
            team = board.registerNewTeam(TEAM_NAME);
        } else {
            team = board.getTeam(TEAM_NAME);
        }

        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
    }

    public static void cleanup() {
        if (team != null) {
            team.unregister();
            team = null;
        }
    }

    public static void addPlayer(Player player) {
        if (team != null && !team.hasEntry(player.getName())) {
            team.addEntry(player.getName());
        }
    }

    public static void removePlayer(Player player) {
        if (team != null && team.hasEntry(player.getName())) {
            team.removeEntry(player.getName());
        }
    }

    public static boolean containsPlayer(Player player) {
        return team != null && team.hasEntry(player.getName());
    }
}
