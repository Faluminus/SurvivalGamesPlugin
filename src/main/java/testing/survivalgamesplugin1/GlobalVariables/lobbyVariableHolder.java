package testing.survivalgamesplugin1.GlobalVariables;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class lobbyVariableHolder {

    //Player oriented lobby variables
    //modify as you want
    private Player[] joined_players = new Player[0];
    private int players = 0;
    private final int max_players = 16;
    private final int min_players_to_start  = max_players - 5;

    //SG lobby locations
    //modify as you want
    private World world;
    private final double xLobby = 0;
    private final double yLobby = 0;
    private final double zLobby = 0;
    private final float yaw = 0;
    private final float pitch = 0;



    public Player[] getJoined_players() {
        return joined_players;
    }

    public void setJoined_players(Player[] joined_players) {
        this.joined_players = joined_players;
    }

    public int getPlayers() {
        return players;
    }
    public void setPlayers(int players) {
        this.players = players;
    }
    public int getMaxPlayers() {
        return max_players;
    }
    public int getMinPlayers_to_start() {
        return min_players_to_start;
    }
}
