package testing.survivalgamesplugin1.Commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import testing.survivalgamesplugin1.GlobalVariables.lobbyVariableHolder;

import java.lang.reflect.Array;

public class SGLobby {

    private lobbyVariableHolder lobbyVariables;
    private Player[] joined_players;
    private int players;
    private final int maxPlayers;
    public SGLobby(lobbyVariableHolder lobbyVariables) {
        this.joined_players = lobbyVariables.getJoined_players();
        this.players = lobbyVariables.getPlayers();
        this.lobbyVariables = lobbyVariables;
        this.maxPlayers = lobbyVariables.getMaxPlayers();
    }


    public void PlaySGCommand(CommandSender sender, String[] args){

        Player player = (Player) sender;
        boolean isPlayerAlreadyInLobby = CheckIfPlayerIsAlreadyInLobby(player);

        if(isPlayerAlreadyInLobby){

            sendPlayerToGeneralLobby(player);
            removePlayerFromLobbyList(player);

            sender.sendMessage("Leaving SG lobby , se ya next time :)");
        }
        if(players != maxPlayers && !isPlayerAlreadyInLobby) {

            sendPlayerToSGLobby(player);
            insertPlayerIntoLobbyList(player);
            sender.sendMessage("Joining SG lobby , have fun :)");
            sender.sendMessage(String.format("%d",players));

        }

    }
    private void insertPlayerIntoLobbyList(Player player){
        for(int i = 0; i < maxPlayers; i++){
            if(joined_players[i] == null){

                joined_players[i] = player;
                lobbyVariables.setJoined_players(joined_players);

                players++;
                lobbyVariables.setPlayers(players);

                return;
            }
        }
    }


    private void removePlayerFromLobbyList(Player player){
        for(int i = 0; i < maxPlayers; i++){
            if(joined_players[i].equals(player)){

                joined_players[i] = null;
                lobbyVariables.setJoined_players(joined_players);

                players--;
                lobbyVariables.setPlayers(players);

                return;
            }
        }
    }



    private boolean CheckIfPlayerIsAlreadyInLobby(Player player) {
        for (int i = 0; i < Array.getLength(joined_players); i++) {
            if (joined_players[i] != null && joined_players[i].equals(player)) {
                return true;
            }
        }
        return false;
    }


    private void sendPlayerToSGLobby(Player player){
        World world = player.getWorld();
        double x = 100; // Example x-coordinate
        double y = 70;  // Example y-coordinate
        double z = -50; // Example z-coordinate
        float yaw = 0;  // Example yaw (rotation around y-axis)
        float pitch = 0; // Example pitch (vertical rotation)

        Location loc = new Location(world,x,y,z);
        player.teleport(loc);
    }



    private void sendPlayerToGeneralLobby(Player player){

        World world = player.getWorld();
        double x = 100; // Example x-coordinate
        double y = 70;  // Example y-coordinate
        double z = -50; // Example z-coordinate
        float yaw = 0;  // Example yaw (rotation around y-axis)
        float pitch = 0; // Example pitch (vertical rotation)

        Location loc = new Location(world,x,y,z);
        player.teleport(loc);
    }
}
